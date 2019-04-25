package com.ft.business.component.userinfo.service;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.https.HttpsModule;
import com.bristua.framework.rx.AndroidRxManager;
import com.bristua.framework.system.AppContext;
import com.bristua.ft.protocol.ProtocolFactory;
import com.example.user_info.R;
import com.ft.business.component.userinfo.restapi.IWxInfoApi;
import com.ft.business.component.userinfo.wrapper.WXInfoWrapper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class WXInfoService {

    /**
     * 执行获取微信用户信息
     *
     * @param pResult
     */
    public static void wxInfo(@NonNull final IFlutterResult pResult, WXInfoWrapper wxInfoWrapper) {
        AndroidRxManager.clear();
        AppContext appContext = AppConfig.getInstance().getAppContext();
        Context context = appContext.getContext();
        //执行retrofit 下的rx模式
        Retrofit retrofit = HttpsModule.getInstance().getRetrofit();
        if (retrofit == null) {
            String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.userpay_error_http), 500, null);
            pResult.success(errorTip, 500, null);
            return;
        }
        IWxInfoApi restApi = retrofit.create(IWxInfoApi.class);
        final String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.userpay_error_http), 500, null);
        Disposable disposable = restApi.wxInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String result) {
                        AndroidRxManager.clear();
                        pResult.success(result, 500, null);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        AndroidRxManager.clear();
                        pResult.success(errorTip, 500, null);
                    }
                });
        AndroidRxManager.addDisposable(disposable);


    }
}
