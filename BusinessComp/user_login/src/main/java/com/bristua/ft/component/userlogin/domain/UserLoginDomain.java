package com.bristua.ft.component.userlogin.domain;
import android.support.annotation.NonNull;
import com.bristua.framework.define.IFlutterResult;

/**
 * 用户领域模型
 * @author richsjeson
 */
public interface UserLoginDomain {
    /**
     * 用户领域模型 登录
     * @param pFlutterResult 向应用层层进行回调的数据
     */
    void login(@NonNull IFlutterResult pFlutterResult);
}
