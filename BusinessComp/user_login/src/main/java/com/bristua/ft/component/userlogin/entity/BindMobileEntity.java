package com.bristua.ft.component.userlogin.entity;
import com.bristua.ft.component.userlogin.wrapper.BindUserWrapper;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * @author richsjeson
 * 绑定个人信息
 */
public class BindMobileEntity implements IEntity<BindUserWrapper> {

    private BindUserWrapper mInfo;
    @Override
    public void setObjectValue(BindUserWrapper mobileUserInfo) {
        this.mInfo=mobileUserInfo;
    }

    @Override
    public BindUserWrapper getObjectValue() {
        return this.mInfo;
    }
}
