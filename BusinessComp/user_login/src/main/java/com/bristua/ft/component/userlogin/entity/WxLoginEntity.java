package com.bristua.ft.component.userlogin.entity;

import com.bristua.ft.component.userlogin.repository.WxUserInfo;
import com.nd.adhoc.framework.entity.IEntity;

public class WxLoginEntity implements IEntity<WxUserInfo> {

    private WxUserInfo wxUserInfo;

    @Override
    public void setObjectValue(WxUserInfo wxUserInfo) {
        this.wxUserInfo=wxUserInfo;
    }

    @Override
    public WxUserInfo getObjectValue() {
        return this.wxUserInfo;
    }
}
