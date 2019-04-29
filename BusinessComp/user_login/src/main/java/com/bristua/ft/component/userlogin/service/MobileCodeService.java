package com.bristua.ft.component.userlogin.service;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.https.HttpsModule;
import com.bristua.framework.rx.AndroidRxManager;
import com.bristua.framework.system.AppContext;
import com.bristua.ft.component.userlogin.R;
import com.bristua.ft.component.userlogin.event.MobileEvent;
import com.bristua.ft.component.userlogin.restapi.ISmsCodeApi;
import com.bristua.ft.protocol.ProtocolFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * @author richsjeson
 * 验证码倒计时
 */
public class MobileCodeService {

    private static int time = 60;

    /**
     * 验证码倒计时
     *
     * @param pResult
     */
    public static void getValidCode(@NonNull final IFlutterResult pResult) {
        AndroidRxManager.clear();
        AppContext appContext = AppConfig.getInstance().getAppContext();
        Context context = appContext.getContext();
        String mobilePhone = MobileEvent.getInstance().getPhone();
        if (TextUtils.isEmpty(mobilePhone)) {
            String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.userlogin_error_mobile), 500, null);
            pResult.success(errorTip, 500, errorTip);
            return;
        }

        //执行retrofit 下的rx模式
        Retrofit retrofit = HttpsModule.getInstance().getRetrofit();
        if (retrofit == null) {
            String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.userlogin_error_http), 500, null);
            pResult.success(errorTip, 500, null);
            return;
        }
        ISmsCodeApi restApi = retrofit.create(ISmsCodeApi.class);
        Disposable disposable = restApi.getSmsCode(mobilePhone)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String result) {
                        AndroidRxManager.clear();
                        String success = ProtocolFactory.convertToJson("", 500, result);
                        pResult.success(success, 500, null);
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
