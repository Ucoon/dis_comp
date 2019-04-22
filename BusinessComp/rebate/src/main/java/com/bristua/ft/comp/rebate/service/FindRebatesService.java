package com.bristua.ft.comp.rebate.service;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSON;
import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.https.HttpsModule;
import com.bristua.framework.rx.AndroidRxManager;
import com.bristua.framework.system.AppContext;
import com.bristua.ft.comp.rebate.R;
import com.bristua.ft.comp.rebate.restapi.IQueryFirendConsumeApi;
import com.bristua.ft.comp.rebate.wrapper.RebateResultWrapper;
import com.bristua.ft.protocol.ProtocolFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * 获取返现列表信息的服务
 *
 * @author richsjeson
 */
public class FindRebatesService {
    /**
     * 获取返现详情
     */
    public static void findIntegral(int pageSize, int pageNum, @NonNull final IFlutterResult pResult) {

        AndroidRxManager.clear();
        AppContext appContext = AppConfig.getInstance().getAppContext();
        Context context = appContext.getContext();
        //执行retrofit 下的rx模式
        Retrofit retrofit = HttpsModule.getInstance().getRetrofit();
        if (retrofit == null) {
            String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.rebate_error_http), 500, null);
            pResult.success(null, 500, errorTip);
            return;
        }
        IQueryFirendConsumeApi restApi = retrofit.create(IQueryFirendConsumeApi.class);
        Disposable disposable = restApi.queryIntegral(pageNum,pageSize)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String result) {
                        AndroidRxManager.clear();
                        RebateResultWrapper wrapper= JSON.parseObject(result,RebateResultWrapper.class);
                        String errorTip = ProtocolFactory.convertToJson("", 200, wrapper);
                        pResult.success(errorTip,500,null);
                     }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        AndroidRxManager.clear();
                        String errorTip = ProtocolFactory.convertToJson(throwable.getLocalizedMessage(), 500, null);
                        pResult.success(errorTip,500,null);
                    }
                });

        AndroidRxManager.addDisposable(disposable);

    }
}
