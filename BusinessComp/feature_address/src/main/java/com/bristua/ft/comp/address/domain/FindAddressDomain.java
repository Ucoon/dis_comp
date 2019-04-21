package com.bristua.ft.comp.address.domain;
import android.support.annotation.NonNull;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.comp.address.entity.AddressEntity;
import com.bristua.ft.comp.address.entity.FindAddressEntity;
import com.bristua.ft.comp.address.service.AddAddressService;
import com.bristua.ft.comp.address.service.FindAddressService;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 查找地址
 * @author richsjeson
 */
public class FindAddressDomain implements IDomain {

    @Override
    public void execute(@NonNull IEntity pEntity, @NonNull IFlutterResult pResult) {
        FindAddressEntity entity= (FindAddressEntity) pEntity;
        //地址实体类
        FindAddressService.find(entity.getObjectValue().getPageNo(),entity.getObjectValue().getPageSize(),pResult);
    }
}
