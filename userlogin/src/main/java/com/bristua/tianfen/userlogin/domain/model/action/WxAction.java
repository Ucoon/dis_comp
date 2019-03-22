package com.bristua.tianfen.userlogin.domain.model.action;

import android.support.annotation.Nullable;

/**
 * 微信登录方式
 * @author richsjeson
 */
public class WxAction {

    private String mAppId;

    private String mCode;


    private WxAction(){}

    private static class WxActionHolder{

        static WxAction INSTANCE=new WxAction();
    }

    public static WxAction getInstance(){
        return WxActionHolder.INSTANCE;
    }

    public void saveAppId(@Nullable String pAppId){

        this.mAppId=pAppId;
    }

    public void saveCode(@Nullable String pCode){

        this.mCode=pCode;
    }

    public String getAppId() {
        return mAppId;
    }

    public String getCode() {
        return mCode;
    }

    public void release(){
        WxActionHolder.INSTANCE=null;
    }
}
