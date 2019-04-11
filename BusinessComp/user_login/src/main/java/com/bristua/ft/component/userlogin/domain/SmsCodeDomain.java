package com.bristua.ft.component.userlogin.domain;
import android.support.annotation.NonNull;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.component.userlogin.service.MobileCodeService;

/**
 * smsCode层
 */
public class SmsCodeDomain implements UserLoginDomain {
    @Override
    public void login(@NonNull IFlutterResult pFlutterResult) {
        MobileCodeService.getValidCode(pFlutterResult);
    }
}
