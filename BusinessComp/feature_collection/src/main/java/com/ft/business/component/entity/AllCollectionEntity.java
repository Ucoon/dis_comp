package com.ft.business.component.entity;

import com.ft.business.component.wrapper.AllCollectionWrapper;
import com.nd.adhoc.framework.entity.IEntity;

public class AllCollectionEntity implements IEntity<AllCollectionWrapper> {

    private AllCollectionWrapper mInfo;

    @Override
    public void setObjectValue(AllCollectionWrapper mobileUserInfo) {
        this.mInfo = mobileUserInfo;
    }

    @Override
    public AllCollectionWrapper getObjectValue() {
        return this.mInfo;
    }
}
