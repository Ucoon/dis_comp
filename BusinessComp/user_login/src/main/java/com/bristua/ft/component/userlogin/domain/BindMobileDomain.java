package com.bristua.ft.component.userlogin.domain;

import android.support.annotation.NonNull;

import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.component.userlogin.entity.BindMobileEntity;
import com.bristua.ft.component.userlogin.service.BindUserInfoService;
import com.bristua.ft.component.userlogin.service.MobileCodeService;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 完善手机号
 */
public class BindMobileDomain implements IDomain {
    @Override
    public void execute(@NonNull IEntity iEntity, @NonNull IFlutterResult pFlutterResult) {
        BindMobileEntity entity= (BindMobileEntity) iEntity;
        BindUserInfoService.bind(entity.getObjectValue(),pFlutterResult);
    }
}
