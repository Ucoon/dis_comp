package com.ft.business.component.entity;

import com.ft.business.component.wrapper.GoodsEvaluateWrapper;
import com.nd.adhoc.framework.entity.IEntity;

public class GoodsEvaluateEntity implements IEntity<GoodsEvaluateWrapper> {

    private GoodsEvaluateWrapper mInfo;

    @Override
    public void setObjectValue(GoodsEvaluateWrapper mobileUserInfo) {
        this.mInfo = mobileUserInfo;
    }

    @Override
    public GoodsEvaluateWrapper getObjectValue() {
        return this.mInfo;
    }
}
