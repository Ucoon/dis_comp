package com.bristua.ft.component.userlogin.wrapper;

/**
 * @author richsjeson
 * 移动用户的wrapper
 * 新增用户短信的wrapper
 */
public class UserSmsWrapper implements UserWrapper {

    private String phone;

    private String  type;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
