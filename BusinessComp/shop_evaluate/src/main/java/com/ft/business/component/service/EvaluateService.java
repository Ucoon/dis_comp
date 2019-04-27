package com.ft.business.component.service;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.https.HttpsModule;
import com.bristua.framework.rx.AndroidRxManager;
import com.bristua.framework.system.AppContext;
import com.bristua.ft.protocol.ProtocolFactory;
import com.ft.business.component.restapi.IEvaluateApi;
import com.ft.business.component.wrapper.AllEvaluateResult;
import com.ft.business.component.wrapper.AllEvaluateWrapper;
import com.ft.business.component.wrapper.GoodsEvaluateWrapper;
import com.wc.shop_evaluate.R;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

public class EvaluateService {

    /**
     * 执行商品评价
     *
     * @param pResult
     */
    public static void goodsEvaluate(@NonNull final IFlutterResult pResult, GoodsEvaluateWrapper goodsEvaluateWrapper) {
        AndroidRxManager.clear();
        AppContext appContext = AppConfig.getInstance().getAppContext();
        Context context = appContext.getContext();
        //执行retrofit 下的rx模式
        Retrofit retrofit = HttpsModule.getInstance().getRetrofit();
        if (retrofit == null) {
            String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.shopevaluate_error_http), 500, null);
            pResult.success(errorTip, 500, null);
            return;
        }
        IEvaluateApi restApi = retrofit.create(IEvaluateApi.class);
        final String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.shopevaluate_error_http), 500, null);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString(goodsEvaluateWrapper));
        Disposable disposable = restApi.goodsEvaluate(body)
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


    public static void allEvaluate(@NonNull final IFlutterResult pResult, AllEvaluateWrapper allEvaluateWrapper) {
        AndroidRxManager.clear();
        AppContext appContext = AppConfig.getInstance().getAppContext();
        Context context = appContext.getContext();
        //执行retrofit 下的rx模式
        Retrofit retrofit = HttpsModule.getInstance().getRetrofit();
        if (retrofit == null) {
            String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.allevaluate_error_http), 500, null);
            pResult.success(errorTip, 500, null);
            return;
        }
        IEvaluateApi restApi = retrofit.create(IEvaluateApi.class);
        final String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.allevaluate_error_http), 500, null);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString(allEvaluateWrapper));
        Disposable disposable = restApi.allEvaluate(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String result) {
                        AndroidRxManager.clear();
                        String flutterResult = "";
                        if (TextUtils.isEmpty(result)) {
                            flutterResult = ProtocolFactory.convertToJson("", 200, null);
                        } else {
                            AllEvaluateResult allEvaluateResult = JSON.parseObject(result, AllEvaluateResult.class);
                            if (allEvaluateResult == null) {
                                String errorTip = ProtocolFactory.convertToJson("", 500, null);
                                pResult.success(errorTip, 500, null);
                            } else {
                                flutterResult = ProtocolFactory.convertToJson("", 200, allEvaluateResult);
                            }
                        }
                        pResult.success(flutterResult, 200, null);
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
