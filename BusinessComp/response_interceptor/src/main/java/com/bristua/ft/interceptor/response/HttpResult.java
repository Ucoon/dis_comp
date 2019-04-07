package com.bristua.ft.interceptor.response;

import java.io.Serializable;

/**
 * @author richsjeson
 * 设置http 返回值
 */
public class HttpResult<T> implements Serializable {

    private int code;

    private String msg;

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
