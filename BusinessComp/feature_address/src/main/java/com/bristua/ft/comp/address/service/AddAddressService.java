package com.bristua.ft.comp.address.service;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.https.HttpsModule;
import com.bristua.framework.rx.AndroidRxManager;
import com.bristua.framework.system.AppContext;
import com.bristua.ft.comp.address.R;
import com.bristua.ft.comp.address.restapi.IAddressApi;
import com.bristua.ft.comp.address.wrapper.AddressWrapper;
import com.bristua.ft.protocol.ProtocolFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

/**
 * @author richsjeson
 * 新增地址服务
 */
public class AddAddressService {

    /**
     * 此处加入rxjava相关的代码
     *
     * @param pAddrsss
     * @param pResult
     */
    public static void add(@NonNull AddressWrapper pAddrsss, @NonNull final IFlutterResult pResult) {
        AndroidRxManager.clear();
        AppContext appContext = AppConfig.getInstance().getAppContext();
        Context context = appContext.getContext();
        //执行retrofit 下的rx模式
        Retrofit retrofit = HttpsModule.getInstance().getRetrofit();
        if (retrofit == null) {
            String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.address_error_http), 500, null);
            pResult.success(errorTip, 500, null);
            return;
        }
        IAddressApi restApi = retrofit.create(IAddressApi.class);
        ;
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=utf-8"), JSON.toJSON(pAddrsss).toString());
        Disposable disposable = restApi.add(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String result) {
                        AndroidRxManager.clear();
                        pResult.success(!TextUtils.isEmpty(result) ? result : "{\"code\":200,\"msg\":\"保存成功\",\"data\":\"\"}", 200, null);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        AndroidRxManager.clear();
                        String errorTip = ProtocolFactory.convertToJson(throwable.getLocalizedMessage(), 500, null);
                        pResult.success(errorTip, 500, null);

                    }
                });
        AndroidRxManager.addDisposable(disposable);
    }
}
