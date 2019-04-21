package com.bristua.ft.comp.address.entity;

import com.bristua.ft.comp.address.wrapper.DelAddressWrapper;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * @author richsjeson
 */
public class DelAddressEntity implements IEntity<DelAddressWrapper> {

    private DelAddressWrapper mWrapper;
    @Override
    public void setObjectValue(DelAddressWrapper pValue) {

        this.mWrapper=pValue;
    }

    @Override
    public DelAddressWrapper getObjectValue() {
        return this.mWrapper;
    }
}
