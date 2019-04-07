package com.bristua.ft.component.userlogin.service;

import android.support.annotation.NonNull;

import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.rx.AndroidRxManager;
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
