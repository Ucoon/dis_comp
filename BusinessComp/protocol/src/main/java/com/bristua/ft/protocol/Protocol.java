package com.bristua.ft.protocol;

/**
 * @author richsjeson
 * 报文协议体
 */
public class Protocol<T> {

    private String method;

    private T data;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
