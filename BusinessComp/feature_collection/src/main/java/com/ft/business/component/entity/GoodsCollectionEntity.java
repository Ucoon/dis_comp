package com.ft.business.component.entity;

import com.ft.business.component.wrapper.GoodsCollectionWrapper;
import com.nd.adhoc.framework.entity.IEntity;

public class GoodsCollectionEntity implements IEntity<GoodsCollectionWrapper> {

    private GoodsCollectionWrapper mInfo;

    @Override
    public void setObjectValue(GoodsCollectionWrapper mobileUserInfo) {
        this.mInfo = mobileUserInfo;
    }

    @Override
    public GoodsCollectionWrapper getObjectValue() {
        return this.mInfo;
    }
}
