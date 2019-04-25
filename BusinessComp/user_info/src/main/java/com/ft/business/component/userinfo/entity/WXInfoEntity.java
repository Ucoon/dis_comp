package com.ft.business.component.userinfo.entity;

import com.ft.business.component.userinfo.wrapper.WXInfoWrapper;
import com.nd.adhoc.framework.entity.IEntity;

public class WXInfoEntity implements IEntity<WXInfoWrapper> {

    private WXInfoWrapper mInfo;

    @Override
    public void setObjectValue(WXInfoWrapper mobileUserInfo) {
        this.mInfo = mobileUserInfo;
    }

    @Override
    public WXInfoWrapper getObjectValue() {
        return this.mInfo;
    }
}
