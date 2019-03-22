package com.bristua.tianfen.userlogin.domain.model.repository;

import com.bristua.tianfen.userlogin.domain.model.action.WxAction;

/**
 * 微信登录 --领域
 * @author richsjeson
 */
public class WxLoginRepository implements IUserLoginRepository {

    public String getCode() {
        return WxAction.getInstance().getCode();
    }

    public String getAppId(){
        return WxAction.getInstance().getAppId();
    }

}
