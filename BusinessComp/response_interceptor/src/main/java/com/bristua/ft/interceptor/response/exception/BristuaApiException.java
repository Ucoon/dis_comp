package com.bristua.ft.interceptor.response.exception;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.IOException;

/**
 * 全局统一异常事件捕获
 * @author richsjeson
 */
public class BristuaApiException extends IOException {

    private int mCode;

    public BristuaApiException(@NonNull String pMsg, int pErrorCode){
        super(pMsg);
        this.mCode=pErrorCode;
    }

    public int getCode() {
        return mCode;
    }

    public void setCode(int pCode) {
        this.mCode = pCode;
    }
}
