package com.bristua.tianfen.userlogin.domain.model;

import android.support.annotation.Nullable;

import com.bristua.tianfen.userlogin.domain.model.action.MobileAction;
import com.bristua.tianfen.userlogin.domain.model.action.WxAction;

/**
 * 用户领域 抽象类
 * @author richsjeson
 */
public  class UserInfo {

    private String mPhone;

    private String mNickName;

    public UserInfo(String mPhone, String mNickName) {
        this.mPhone = mPhone;
        this.mNickName = mNickName;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getNickName() {
        return mNickName;
    }
    /**
      具体业务-- 输入密码
     */
    public void inputPassword(@Nullable String pPassword){
        MobileAction.getInstance().inputPassword(pPassword);
    }
    /**
     *  具体业务-- 输入手机号
     */
    public void inputPhone(@Nullable String pPhone){
        MobileAction.getInstance().inputPhone(pPhone);
    }

    public void saveCode(@Nullable String pCode){
        WxAction.getInstance().saveCode(pCode);
    }

    public void saveAppId(@Nullable String pAppId){
        WxAction.getInstance().saveAppId(pAppId);
    }


}
