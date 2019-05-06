package com.bristua.ft.component.userlogin.service;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.https.HttpsModule;
import com.bristua.framework.rx.AndroidRxManager;
import com.bristua.framework.system.AppContext;
import com.bristua.ft.component.userlogin.R;
import com.bristua.ft.component.userlogin.event.MobileEvent;
import com.bristua.ft.component.userlogin.param.MobileParam;
import com.bristua.ft.component.userlogin.repository.MobileUserInfo;
import com.bristua.ft.component.userlogin.restapi.IMobileUserLoginApi;
import com.bristua.ft.protocol.ProtocolFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

/**
 * @author richsjeson
 * 手机用户登录模块
 */
public class MobileUserLoginService {

    /**
     * 执行用户登录
     *
     * @param pResult
     */
    public static void login(@NonNull final IFlutterResult pResult) {
        AndroidRxManager.clear();
        AppContext appContext = AppConfig.getInstance().getAppContext();
        Context context = appContext.getContext();
        String mobilePhone = MobileEvent.getInstance().getPhone();
        String phoneCode = MobileEvent.getInstance().getPhoneCode();
        String pInviteCode = MobileEvent.getInstance().getInviteCode();
        String inviteCode = TextUtils.isEmpty(pInviteCode) ? "" : pInviteCode;
        if (TextUtils.isEmpty(mobilePhone)) {
            String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.userlogin_error_mobile), 500, null);
            pResult.success(errorTip, 500, null);
            return;
        }
        if (TextUtils.isEmpty(phoneCode)) {
            String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.userlogin_error_validcode), 500, null);
            pResult.success(errorTip, 500, null);
            return;
        }
        //执行retrofit 下的rx模式
        Retrofit retrofit = HttpsModule.getInstance().getRetrofit();
        if (retrofit == null) {
            String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.userlogin_error_http), 500, null);
            pResult.success(errorTip, 500, null);
            return;
        }
        IMobileUserLoginApi restApi = retrofit.create(IMobileUserLoginApi.class);
        MobileParam userInfo = new MobileParam();
        userInfo.setPhone(mobilePhone);
        userInfo.setPhoneCode(phoneCode);
        userInfo.setInviteCode(inviteCode);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=utf-8"), JSON.toJSON(userInfo).toString());
        restApi.userLogin(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<String>() {

                    @Override
                    public void onNext(String result) {
                        String flutterSuccess = ProtocolFactory.convertToJson("验证码发送成功", 200, result);
                        pResult.success(flutterSuccess, 200, null);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        String errorTip = ProtocolFactory.convertToJson(throwable.getLocalizedMessage(), 500, null);
                        pResult.success(errorTip, 500, null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
