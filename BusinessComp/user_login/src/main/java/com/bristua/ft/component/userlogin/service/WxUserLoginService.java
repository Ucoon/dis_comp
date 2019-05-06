package com.bristua.ft.component.userlogin.service;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.https.HttpsModule;
import com.bristua.framework.rx.AndroidRxManager;
import com.bristua.framework.system.AppContext;
import com.bristua.ft.component.userlogin.R;
import com.bristua.ft.component.userlogin.restapi.IWxLoginApi;
import com.bristua.ft.protocol.ProtocolFactory;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class WxUserLoginService {

    /**
     * 执行用户登录
     * @param pResult
     */
    public static void login(@NonNull final IFlutterResult pResult, @NonNull String pCode){
        AndroidRxManager.clear();
        AppContext appContext= AppConfig.getInstance().getAppContext();
        Context context=appContext.getContext();
        //执行retrofit 下的rx模式
        Retrofit retrofit= HttpsModule.getInstance().getRetrofit();
        if(retrofit == null){
            String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.userlogin_error_http), 500, null);
            pResult.success(errorTip,500,null);
            return;
        }
        IWxLoginApi restApi= retrofit.create(IWxLoginApi.class);
      restApi.wxLogin(pCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new DisposableObserver<String>() {

                  @Override
                  public void onNext(String result) {
                      String flutterSuccess = ProtocolFactory.convertToJson("验证码发送成功", 200, result);
                      pResult.success(flutterSuccess,200,null);
                  }

                  @Override
                  public void onError(Throwable throwable) {
                      String errorTip = ProtocolFactory.convertToJson(throwable.getLocalizedMessage(), 500, null);
                      pResult.success(errorTip,500,null);
                  }

                  @Override
                  public void onComplete() {

                  }
              });

    }
}
