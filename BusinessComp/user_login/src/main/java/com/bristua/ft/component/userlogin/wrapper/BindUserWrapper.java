package com.bristua.ft.component.userlogin.wrapper;
/**
 * @author richsjeson
 * 绑定用户信息
 */
public class BindUserWrapper extends MobileUserWrapper {

    private String inviteCode;
    public String getInviteCode() {
        return inviteCode.equals("-")?"0":inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}
