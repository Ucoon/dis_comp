package com.ft.business.component.entity;

import com.ft.business.component.wrapper.AllEvaluateWrapper;
import com.ft.business.component.wrapper.GoodsEvaluateWrapper;
import com.nd.adhoc.framework.entity.IEntity;

public class AllEvaluateEntity implements IEntity<AllEvaluateWrapper> {

    private AllEvaluateWrapper mInfo;

    @Override
    public void setObjectValue(AllEvaluateWrapper mobileUserInfo) {
        this.mInfo = mobileUserInfo;
    }

    @Override
    public AllEvaluateWrapper getObjectValue() {
        return this.mInfo;
    }
}
