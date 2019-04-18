package com.bristua.ft.component.userlogin.service;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.https.HttpsModule;
import com.bristua.framework.rx.AndroidRxManager;
import com.bristua.framework.system.AppContext;
import com.bristua.ft.component.userlogin.R;
import com.bristua.ft.component.userlogin.restapi.IWxLoginApi;
import com.bristua.ft.protocol.ProtocolFactory;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class WxUserLoginService {

    /**
     * 执行用户登录
     * @param pResult
     */
    public static void login(@NonNull final IFlutterResult pResult, @NonNull String pCode){
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
        IWxLoginApi restApi= retrofit.create(IWxLoginApi.class);
        final String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.userlogin_error_http), 500, null);
        Disposable disposable=restApi.wxLogin(pCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String pResult) {
                        AndroidRxManager.clear();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable){
                        AndroidRxManager.clear();
                        pResult.success(errorTip,500,null);
                    }
                });
        AndroidRxManager.addDisposable(disposable);


    }
}
