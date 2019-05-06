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
import com.ft.business.component.restapi.ICollectionApi;
import com.ft.business.component.wrapper.AllCollectionResult;
import com.ft.business.component.wrapper.AllCollectionWrapper;
import com.ft.business.component.wrapper.GoodsCollectionWrapper;
import com.wc.feature_collection.R;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class CollectionService {

    /**
     * 执行商品收藏
     *
     * @param pResult
     */
    public static void goodsCollection(@NonNull final IFlutterResult pResult, GoodsCollectionWrapper goodsEvaluateWrapper) {
        AndroidRxManager.clear();
        AppContext appContext = AppConfig.getInstance().getAppContext();
        Context context = appContext.getContext();
        //执行retrofit 下的rx模式
        Retrofit retrofit = HttpsModule.getInstance().getRetrofit();
        if (retrofit == null) {
            String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.shopcollection_error_http), 500, null);
            pResult.success(errorTip, 500, null);
            return;
        }
        ICollectionApi restApi = retrofit.create(ICollectionApi.class);
        final String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.shopcollection_error_http), 500, null);
        restApi.goodsCollection(goodsEvaluateWrapper.getGoodsId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<String>() {

                    @Override
                    public void onNext(String result) {
                        pResult.success(result, 500, null);
                    }

                    @Override
                    public void onError(Throwable e) {
                        pResult.success(errorTip, 500, null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public static void allCollection(@NonNull final IFlutterResult pResult, AllCollectionWrapper allCollectionWrapper) {
        AndroidRxManager.clear();
        AppContext appContext = AppConfig.getInstance().getAppContext();
        Context context = appContext.getContext();
        //执行retrofit 下的rx模式
        Retrofit retrofit = HttpsModule.getInstance().getRetrofit();
        if (retrofit == null) {
            String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.allcollection_error_http), 500, null);
            pResult.success(errorTip, 500, null);
            return;
        }
        ICollectionApi restApi = retrofit.create(ICollectionApi.class);
        final String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.allcollection_error_http), 500, null);
        Disposable disposable = restApi.allCollection(allCollectionWrapper.getPageNo(), allCollectionWrapper.getPageSize())
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
                            AllCollectionResult allEvaluateResult = JSON.parseObject(result, AllCollectionResult.class);
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
