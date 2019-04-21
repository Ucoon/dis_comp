package com.bristua.ft.comp.address.entity;

import com.bristua.ft.comp.address.wrapper.AddressWrapper;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 地址实体
 * @author richsjeson
 */
public class AddressEntity implements IEntity<AddressWrapper> {

    private AddressWrapper mAddress;


    @Override
    public void setObjectValue(AddressWrapper pAddress) {
        this.mAddress=pAddress;
    }

    @Override
    public AddressWrapper getObjectValue() {
        return mAddress;
    }
}
