package com.bristua.ft.comp.address.domain;
import android.support.annotation.NonNull;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.comp.address.entity.Address;
import com.bristua.ft.comp.address.entity.AddressEntity;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 新增地址
 * @author richsjeson
 */
public class AddressAddDomain implements IDomain {

    @Override
    public void execute(@NonNull IEntity pEntity, @NonNull IFlutterResult pResult) {
        AddressEntity entity= (AddressEntity) pEntity;
        Address address=entity.getObjectValue();
    }
}
