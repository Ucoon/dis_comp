package com.bristua.ft.component.userlogin.service;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.https.HttpsModule;
import com.bristua.framework.rx.AndroidRxManager;
import com.bristua.framework.system.AppContext;
import com.bristua.ft.component.userlogin.R;
import com.bristua.ft.component.userlogin.restapi.IBinderUserMobileApi;
import com.bristua.ft.component.userlogin.restapi.IGetUserInfoApi;
import com.bristua.ft.component.userlogin.wrapper.BindUserWrapper;
import com.bristua.ft.component.userlogin.wrapper.UserInfoWrapper;
import com.bristua.ft.protocol.ProtocolFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * @author richsjeson
 * 用户信息获取
 */
public class BindUserInfoService {
    /**
     * 获取用户信息
     * @param pResult
     */
    public static  void bind(BindUserWrapper wrapper,@NonNull final IFlutterResult pResult){
        AndroidRxManager.clear();
        AppContext appContext= AppConfig.getInstance().getAppContext();
        Context context=appContext.getContext();
        //执行retrofit 下的rx模式
        Retrofit retrofit= HttpsModule.getInstance().getRetrofit();
        if(retrofit == null){
            String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.userlogin_error_http), 500, null);
            pResult.success(errorTip,500,null);
            return;
        }
        IBinderUserMobileApi restApi= retrofit.create(IBinderUserMobileApi.class);
        Disposable disposable=restApi.bindUserMobile(wrapper.getPhone(),wrapper.getSmsCode(),wrapper.getInviteCode())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String result) {
                        AndroidRxManager.clear();
                        String flutterSuccess = ProtocolFactory.convertToJson("", 200, result);
                        pResult.success(flutterSuccess,200,null);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable){
                        AndroidRxManager.clear();
                        String flutterSuccess = ProtocolFactory.convertToJson(throwable.getMessage(), 500, "");
                        pResult.success(flutterSuccess,500,null);
                    }
                });
        AndroidRxManager.addDisposable(disposable);
    }
}
