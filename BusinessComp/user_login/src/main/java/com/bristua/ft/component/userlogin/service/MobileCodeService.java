package com.bristua.ft.component.userlogin.service;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.rx.AndroidRxManager;
import com.bristua.framework.system.AppContext;
import com.bristua.ft.component.userlogin.R;
import com.bristua.ft.component.userlogin.event.MobileEvent;

import java.util.concurrent.TimeUnit;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * @author richsjeson
 * 验证码倒计时
 */
public class MobileCodeService {

    private static int time = 60;

    /**
     * 验证码倒计时
     * @param pResult
     */
    public static void getValidCode(@NonNull final IFlutterResult pResult) {

        AndroidRxManager.clear();
        AppContext appContext= AppConfig.getInstance().getAppContext();
        Context context=appContext.getContext();
        String mobilePhone= MobileEvent.getInstance().getPhone();
        if(TextUtils.isEmpty(mobilePhone)){
            pResult.error(context.getResources().getString(R.string.userlogin_error_mobile),500);
            return;
        }
        AndroidRxManager.clear();
        Disposable disposable= Flowable.intervalRange(0,time,0,1,TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        pResult.success(String.valueOf(time-aLong), 200, "");
                    }
                }).doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        pResult.success(String.valueOf(time), 200, "");
                        AndroidRxManager.clear();
                    }
                }).subscribe();

        AndroidRxManager.addDisposable(disposable);
    }
}
