package com.bristua.ft.component.userlogin.domain;
import android.support.annotation.NonNull;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.component.userlogin.service.MobileUserLoginService;

/**
 * @author richsjeson
 * 手机用户领域 -- 执行用户登录
 */
public class MobileUserDomain implements UserLoginDomain {

    @Override
    public void login(@NonNull IFlutterResult pFlutterResult) {

        MobileUserLoginService.login(pFlutterResult);
    }
}
