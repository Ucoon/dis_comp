package com.bristua.ft.component.userlogin.business;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSON;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.component.userlogin.R;
import com.bristua.ft.component.userlogin.domain.UserLoginDomainFactory;
import com.bristua.ft.component.userlogin.wrapper.BindUserWrapper;
import com.bristua.ft.protocol.ProtocolFactory;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 获取用户信息的business
 */
public class BindMobileBusiness implements IManager {
    @Override
    public void execute(@NonNull IFlutterResult pResult, @NonNull IEntity pEntity, @NonNull String pData, @NonNull String pMethod, @NonNull Context context) {
        BindUserWrapper wrapper= JSON.parseObject(pData,BindUserWrapper.class);
        String parserFromProtocol = ProtocolFactory.convertToJson(context.getResources().getString(R.string.userlogin_failure_parser), 500, null);
        if(wrapper == null){
            pResult.success(parserFromProtocol,500,null);
        }
        IDomain domain= UserLoginDomainFactory.getFactory().getDomain(pMethod);
        if(domain == null){
            pResult.success(parserFromProtocol,500,null);
            return;
        }
        pEntity.setObjectValue(wrapper);
        domain.execute(pEntity,pResult);
    }
}
