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
import com.bristua.ft.component.userlogin.repository.MobileUserInfo;
import com.bristua.ft.component.userlogin.restapi.IMobileUserLoginApi;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

/**
 * @author richsjeson
 * 手机用户登录模块
 */
public class MobileUserLoginService {

    /**
     * 执行用户登录
     * @param pResult
     */
    public static void login(@NonNull final IFlutterResult pResult){
        AndroidRxManager.clear();
        AppContext appContext= AppConfig.getInstance().getAppContext();
        Context context=appContext.getContext();
        String mobilePhone= MobileEvent.getInstance().getPhone();
        String phoneCode=MobileEvent.getInstance().getPhoneCode();
        String pInviteCode=MobileEvent.getInstance().getInviteCode();
        String inviteCode=TextUtils.isEmpty(pInviteCode)?"":pInviteCode;
        if(TextUtils.isEmpty(mobilePhone)){
            pResult.error(context.getResources().getString(R.string.userlogin_error_mobile),500);
            return;
        }
        if(TextUtils.isEmpty(phoneCode)){
            pResult.error(context.getResources().getString(R.string.userlogin_error_validcode),500);
            return;
        }
        //执行retrofit 下的rx模式
        Retrofit retrofit= HttpsModule.getInstance().getRetrofit();
        if(retrofit == null){
            pResult.error(context.getResources().getString(R.string.userlogin_error_http),500);
            return;
        }

        IMobileUserLoginApi restApi= retrofit.create(IMobileUserLoginApi.class);

        MobileUserInfo userInfo=new MobileUserInfo();
        userInfo.setMobilePhone(mobilePhone);
        userInfo.setPhoneCode(phoneCode);
        userInfo.setInviteCode(inviteCode);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=utf-8"), JSON.toJSON(userInfo).toString());


        Disposable disposable=restApi.userLogin(body)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String pResult) {
                        AndroidRxManager.clear();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable){
                        AndroidRxManager.clear();
                    }
                });
        AndroidRxManager.addDisposable(disposable);


    }
}
