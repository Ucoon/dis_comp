package com.bristua.ft.component.userlogin.wrapper;

/**
 * @author richsjeson
 * 微信用户的wrapper
 */
public class WxUserWrapper implements UserWrapper {

    private String appid;

    private String scope;

    private String code;

    private String grantType;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }
}
