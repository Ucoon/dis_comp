package com.bristua.ft.component.userlogin.callback;
import android.support.annotation.NonNull;
import com.bristua.ft.component.userlogin.wrapper.UserWrapper;

/**
 * 用户回调
 * @author richsjeson
 */
public interface IUserLoginCallback {
    /**
     * 数据回调
     * @param pWrapper 领域模型下的wrapper包体
     */
    void onCallback(@NonNull UserWrapper pWrapper);

    /**
     * 登录错误的回调
     * @param pEx
     */
    void onFailure(Exception pEx);
}
