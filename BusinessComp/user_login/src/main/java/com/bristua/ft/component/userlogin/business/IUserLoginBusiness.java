package com.bristua.ft.component.userlogin.business;
import android.support.annotation.NonNull;
import com.bristua.framework.define.IFlutterResult;

/**
 * 用户登录业务
 * @author richsjeson
 */
public interface IUserLoginBusiness  {
    /**
     * 模组执行操作
     * @param pProtocol
     * @param pCallback
     */
    void exec(@NonNull String pProtocol, @NonNull IFlutterResult pCallback);
}
