package com.bristua.ft.comp.address.entity;

import com.bristua.ft.comp.address.wrapper.AddressWrapper;
import com.bristua.ft.comp.address.wrapper.UpAddressWrapper;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 地址实体
 * @author richsjeson
 */
public class UpDateAddressEntity implements IEntity<UpAddressWrapper> {

    private UpAddressWrapper mAddress;


    @Override
    public void setObjectValue(UpAddressWrapper pAddress) {
        this.mAddress=pAddress;
    }

    @Override
    public UpAddressWrapper getObjectValue() {
        return mAddress;
    }
}
