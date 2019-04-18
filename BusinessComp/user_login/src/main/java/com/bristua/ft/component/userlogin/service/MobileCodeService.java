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
import com.bristua.ft.protocol.ProtocolFactory;
import java.util.concurrent.TimeUnit;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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
            String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.userlogin_error_mobile), 500, null);
            pResult.success(errorTip,500,errorTip);
            return;
        }
        AndroidRxManager.clear();
        Disposable disposable= Flowable.intervalRange(0,time,0,1,TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        System.out.println("倒计时"+String.valueOf(time-aLong));
                        String errorTip = ProtocolFactory.convertToJson(null, 200, String.valueOf(time-aLong));
                        pResult.success(errorTip, 200, "");
                    }
                }).doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        String errorTip = ProtocolFactory.convertToJson(null, 200, String.valueOf(time));
                        pResult.success(errorTip, 200, "");
                    }
                }).subscribe();

        AndroidRxManager.addDisposable(disposable);
    }
}
