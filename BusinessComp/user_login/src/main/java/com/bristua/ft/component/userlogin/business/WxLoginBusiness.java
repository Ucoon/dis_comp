package com.bristua.ft.component.userlogin.business;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSON;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.component.userlogin.domain.UserLoginDomainFactory;
import com.bristua.ft.component.userlogin.wrapper.WxLoginWrapper;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

public class WxLoginBusiness implements IManager {
    @Override
    public void execute(@NonNull IFlutterResult pResult, @NonNull IEntity pEntity, @NonNull String pData, @NonNull String pMethod, @NonNull Context context) {

        WxLoginWrapper wrapper= JSON.parseObject(pData, WxLoginWrapper.class);
        if(wrapper == null ){
            return;
        }
        pEntity.setObjectValue(wrapper);
        IDomain domain= UserLoginDomainFactory.getFactory().getDomain(pMethod);
        if(domain == null){
            return;
        }
        domain.execute(pEntity,pResult);
    }
}
