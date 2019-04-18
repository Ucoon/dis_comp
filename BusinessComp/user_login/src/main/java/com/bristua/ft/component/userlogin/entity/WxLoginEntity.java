package com.bristua.ft.component.userlogin.entity;
import com.nd.adhoc.framework.entity.IEntity;

public class WxLoginEntity implements IEntity<String> {

    private String code;


    @Override
    public void setObjectValue(String pValue) {
        this.code=pValue;
    }

    @Override
    public String getObjectValue() {
        return this.code;
    }
}
