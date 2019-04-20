package com.bristua.ft.component.userpay.entity;

import com.bristua.ft.component.userpay.wrapper.WXPayWrapper;
import com.nd.adhoc.framework.entity.IEntity;

public class WXPayEntity implements IEntity<WXPayWrapper> {

    private WXPayWrapper mInfo;

    @Override
    public void setObjectValue(WXPayWrapper mobileUserInfo) {
        this.mInfo = mobileUserInfo;
    }

    @Override
    public WXPayWrapper getObjectValue() {
        return this.mInfo;
    }
}
