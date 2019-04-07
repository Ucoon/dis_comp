package com.bristua.ft.interceptor.response.wrapper;

import java.io.Serializable;

/**
 * 返回的对象数据
 */
public class AccessTokenData implements Serializable {

    private  String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
