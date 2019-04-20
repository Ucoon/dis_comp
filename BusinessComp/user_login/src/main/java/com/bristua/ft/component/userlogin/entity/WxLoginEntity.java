package com.bristua.ft.component.userlogin.entity;
import com.bristua.ft.component.userlogin.wrapper.WxLoginWrapper;
import com.nd.adhoc.framework.entity.IEntity;

public class WxLoginEntity implements IEntity<WxLoginWrapper> {

    private WxLoginWrapper mWrapper;

    @Override
    public void setObjectValue(WxLoginWrapper pValue) {
        this.mWrapper=pValue;
    }

    @Override
    public WxLoginWrapper getObjectValue() {
        return mWrapper;
    }

}
