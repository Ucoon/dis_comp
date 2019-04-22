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
import com.bristua.ft.comp.address.wrapper.UpAddressWrapper;
import com.bristua.ft.protocol.ProtocolFactory;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * @author richsjeson
 * 获取地址列表服务
 */
public class FindAddressService {

    /**
     * 此处加入rxjava相关的代码
     *
     * @param pageNo   页数
     * @param pageSize 页面条数
     * @param pResult
     */
    public static void find(int pageNo, int pageSize, @NonNull final IFlutterResult pResult) {
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
        Disposable disposable = restApi.find(pageNo, pageSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String result) {
                        AndroidRxManager.clear();
                        String flutterResult = "";
                        if (!TextUtils.isEmpty("")) {
                            flutterResult = ProtocolFactory.convertToJson("", 200, null);
                        } else {
                            List<UpAddressWrapper> wrappers = JSON.parseArray(result, UpAddressWrapper.class);
                            if (wrappers == null) {
                                String errorTip = ProtocolFactory.convertToJson("", 500, null);
                                pResult.success(errorTip, 500, null);
                            } else {
                                flutterResult = ProtocolFactory.convertToJson("", 200, wrappers);
                            }
                        }
                        pResult.success(flutterResult, 200, null);
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
