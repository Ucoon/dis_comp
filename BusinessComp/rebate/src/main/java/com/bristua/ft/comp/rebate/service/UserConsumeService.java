package com.bristua.ft.comp.rebate.service;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.https.HttpsModule;
import com.bristua.framework.rx.AndroidRxManager;
import com.bristua.framework.system.AppContext;
import com.bristua.ft.comp.rebate.R;
import com.bristua.ft.comp.rebate.restapi.IQueryFirendConsumeApi;
import com.bristua.ft.comp.rebate.restapi.IQueryUserConsumeApi;
import com.bristua.ft.protocol.ProtocolFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import retrofit2.Retrofit;

/**
 * 获取返现列表信息的服务
 *
 * @author richsjeson
 */
public class UserConsumeService {
    /**
     * 获取返现详情
     */
    public static void queryUserConsumer(@NonNull IFlutterResult pResult) {

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
        IQueryUserConsumeApi restApi = retrofit.create(IQueryUserConsumeApi.class);
        Disposable disposable = restApi.queryUserConsume()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String pResult) {
                        AndroidRxManager.clear();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        AndroidRxManager.clear();
                    }
                });

        AndroidRxManager.addDisposable(disposable);

    }
}
