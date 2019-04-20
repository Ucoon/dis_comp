package com.bristua.ft.component.userpay.service;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSON;
import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.https.HttpsModule;
import com.bristua.framework.rx.AndroidRxManager;
import com.bristua.framework.system.AppContext;
import com.bristua.ft.component.userpay.R;
import com.bristua.ft.component.userpay.UserPayConstant;
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
                        Context context = AppConfig.getInstance().getAppContext().getContext();
                        //此处 不要问我为什么就是为了startActivity的
                        Intent intent = new Intent();
                        intent.setClassName(context.getPackageName(), "com.bristua.flutter.ftshop.WXAwakenActivity");
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra(UserPayConstant.USER_WX_PAY_CODE, 200);
                        intent.putExtra(UserPayConstant.USER_WX_PAY_RESULT, result);
                        intent.putExtra(UserPayConstant.USER_IS_WX_PAY, true);
                        context.startActivity(intent);
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
