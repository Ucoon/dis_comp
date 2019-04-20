package com.bristua.ft.component.userpay.service;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSON;
import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.https.HttpsModule;
import com.bristua.framework.rx.AndroidRxManager;
import com.bristua.framework.system.AppContext;
import com.bristua.ft.component.userpay.R;
import com.bristua.ft.component.userpay.restapi.IWxPayApi;
import com.bristua.ft.component.userpay.wrapper.WXPayWrapper;
import com.bristua.ft.protocol.ProtocolFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

public class WXPayService {

    /**
     * 执行微信支付
     *
     * @param pResult
     */
    public static void wxPay(@NonNull final IFlutterResult pResult, WXPayWrapper wxPayWrapper) {
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
        IWxPayApi restApi = retrofit.create(IWxPayApi.class);
        final String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.userpay_error_http), 500, null);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString(wxPayWrapper));
        Disposable disposable = restApi.wxPay(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String result) {
                        AndroidRxManager.clear();
                        pResult.success(errorTip, 200, result);
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
