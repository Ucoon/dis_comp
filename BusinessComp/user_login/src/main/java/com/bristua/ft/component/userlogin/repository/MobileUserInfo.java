package com.bristua.ft.component.userlogin.repository;

import android.support.annotation.NonNull;

import com.bristua.ft.component.userlogin.event.MobileEvent;

/**
 * @author richsjeson
 * 用户属性
 */
public class MobileUserInfo implements IUserInfo {

    /**
     * 设置手机号
     * @param pMobilePHone 手机号
     */
    public void setMobilePhone(@NonNull String pMobilePHone){
        MobileEvent.getInstance().inputPhoneEvnet(pMobilePHone);
    }
    /**
     * 获取短信的code
     * @param pPhoneCode 短信验证码
     */
    public void setPhoneCode(@NonNull String pPhoneCode){
        MobileEvent.getInstance().inputPhoneCodeEvent(pPhoneCode);
    }
    /**
     * 获取短信的code
     * @param pInvitcode 邀请码
     */
    public void setInviteCode(@NonNull String pInvitcode){
        MobileEvent.getInstance().inputInviteCodeEvent(pInvitcode);
    }


}
