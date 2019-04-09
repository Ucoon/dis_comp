package com.bristua.ft.component.userlogin.wrapper;

/**
 * @author richsjeson
 * 移动用户的wrapper
 */
public class MobileUserWrapper implements UserWrapper {

    private String phone;

    private String smsCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
