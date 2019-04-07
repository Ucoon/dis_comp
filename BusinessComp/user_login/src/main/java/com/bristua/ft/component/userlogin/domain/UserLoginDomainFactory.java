package com.bristua.ft.component.userlogin.domain;

import com.bristua.ft.component.userlogin.UserLoginConstant;

/**
 * 用户服务工厂
 *
 * @author richsjeson
 */
public class UserLoginDomainFactory {

    private static UserLoginDomain mInstance;

    /**
     * 获取用户登录的领域
     *
     * @param mUserType
     * @return
     */
    public static UserLoginDomain getDomain(int mUserType) {
        switch (mUserType) {
            case UserLoginConstant.USER_TYPE_MOBILE:
                mInstance = new MobileUserDomain();
                break;
            case UserLoginConstant.USER_TYPE_WX:
                mInstance = new WxUserDomain();
                break;
            default:
                mInstance = new MobileUserDomain();
                break;
        }
        return mInstance;
    }

    public static void release() {
        mInstance = null;
    }
}
