package com.bristua.ft.protocol;

/**
 * 返回的协议体
 */
public class NativeResult<T> {

    private int code;

    private String messgae;

    private T  data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
