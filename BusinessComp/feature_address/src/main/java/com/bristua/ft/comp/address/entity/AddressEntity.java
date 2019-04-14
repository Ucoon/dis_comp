package com.bristua.ft.comp.address.entity;

import com.nd.adhoc.framework.entity.IEntity;

/**
 * 地址实体
 * @author richsjeson
 */
public class AddressEntity implements IEntity<Address> {

    private Address mAddress;


    @Override
    public void setObjectValue(Address pAddress) {
        this.mAddress=pAddress;
    }

    @Override
    public Address getObjectValue() {
        return mAddress;
    }
}
