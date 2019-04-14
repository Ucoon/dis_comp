package com.bristua.ft.comp.rebate.entity;

import com.bristua.ft.comp.rebate.wrapper.RebateWrapper;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 返现
 * @author richsjeson
 */
public class RebateEntity implements IEntity<RebateWrapper> {

    private  RebateWrapper mRebate;

    @Override
    public void setObjectValue(RebateWrapper pValue) {

        this.mRebate=pValue;
    }

    @Override
    public RebateWrapper getObjectValue() {
        return this.mRebate;
    }
}
