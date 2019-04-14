package com.bristua.ft.component.userlogin.entity;

import com.bristua.ft.component.userlogin.repository.MobileUserInfo;
import com.nd.adhoc.framework.entity.IEntity;

public class MobileLoginEntity implements IEntity<MobileUserInfo> {

    private MobileUserInfo mInfo;
    @Override
    public void setObjectValue(MobileUserInfo mobileUserInfo) {
        this.mInfo=mobileUserInfo;
    }

    @Override
    public MobileUserInfo getObjectValue() {
        return this.mInfo;
    }
}
