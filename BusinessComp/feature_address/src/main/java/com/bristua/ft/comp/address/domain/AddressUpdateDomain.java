package com.bristua.ft.comp.address.domain;

import android.support.annotation.NonNull;

import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.comp.address.entity.AddressEntity;
import com.bristua.ft.comp.address.service.AddAddressService;
import com.bristua.ft.comp.address.service.UpdateAddressService;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 修改地址
 * @author richsjeson
 */
public class AddressUpdateDomain implements IDomain {

    @Override
    public void execute(@NonNull IEntity pEntity, @NonNull IFlutterResult pResult) {
        AddressEntity entity= (AddressEntity) pEntity;
        //地址实体类
        UpdateAddressService.update(entity.getObjectValue(),pResult);
    }
}
