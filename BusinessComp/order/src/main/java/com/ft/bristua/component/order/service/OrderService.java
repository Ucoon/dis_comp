package com.ft.bristua.component.order.service;

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
import com.ft.bristua.component.order.R;
import com.ft.bristua.component.order.restapi.IOrderApi;
import com.ft.bristua.component.order.wrapper.OrderSubmitWrapper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

/**
 * 订单服务
 */
public class OrderService {

    public  static void submit(@NonNull OrderSubmitWrapper pWrapper, @NonNull final IFlutterResult pResult){
        AndroidRxManager.clear();
        AppContext appContext= AppConfig.getInstance().getAppContext();
        Context context=appContext.getContext();
        //执行retrofit 下的rx模式
        Retrofit retrofit= HttpsModule.getInstance().getRetrofit();
        if(retrofit == null){
            String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.order_error_http), 500, null);
            pResult.success(errorTip,500,null);
            return;
        }
        IOrderApi restApi= retrofit.create(IOrderApi.class);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=utf-8"), JSON.toJSON(pWrapper).toString());
        Disposable disposable=restApi.submit(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String result) {
                        AndroidRxManager.clear();
                        pResult.success(result,200,null);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable){
                        AndroidRxManager.clear();
                        String errorTip = ProtocolFactory.convertToJson(throwable.getLocalizedMessage(), 500, null);
                        pResult.success(errorTip,500,null);

                    }
                });
        AndroidRxManager.addDisposable(disposable);
    }


}
