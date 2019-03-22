package com.bristua.tianfen.userlogin.domain.model.action;

import android.support.annotation.Nullable;

/**
 * @author richsjeson
 */
public class MobileAction{

    private String mPhone;

    private String mPassword;


    private MobileAction(){}

    private static class MobileActioHolder{

        static MobileAction INSTANCE=new MobileAction();
    }

    public static MobileAction getInstance(){
        return MobileActioHolder.INSTANCE;
    }

    public void inputPassword(@Nullable String phone){

        this.mPhone=phone;
    }

    public void inputPhone(@Nullable String password){

        this.mPassword=password;
    }



    public String getPassword() {
        return mPhone;
    }

    public String getPhone() {
        return mPassword;
    }

    public void release(){
        MobileActioHolder.INSTANCE=null;
    }
}
