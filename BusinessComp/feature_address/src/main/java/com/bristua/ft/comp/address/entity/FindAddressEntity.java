package com.bristua.ft.comp.address.entity;

import com.bristua.ft.comp.address.wrapper.FindAddressWrapper;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * @author richsjeson
 */
public class FindAddressEntity implements IEntity<FindAddressWrapper> {

    private FindAddressWrapper mWrapper;

    @Override
    public void setObjectValue(FindAddressWrapper pValue) {

        this.mWrapper=pValue;
    }

    @Override
    public FindAddressWrapper getObjectValue() {
        return this.mWrapper;
    }
}
