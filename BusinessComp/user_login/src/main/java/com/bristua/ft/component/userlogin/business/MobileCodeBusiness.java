package com.bristua.ft.component.userlogin.business;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSONObject;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.component.userlogin.domain.UserLoginDomainFactory;
import com.bristua.ft.component.userlogin.repository.MobileUserInfo;
import com.bristua.ft.component.userlogin.wrapper.UserSmsWrapper;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

import static com.bristua.ft.component.userlogin.UserLoginConstant.USER_METHOD_MOBILE;

public class MobileCodeBusiness implements IManager {
    @Override
    public void execute(@NonNull IFlutterResult pResult, @NonNull IEntity pEntity, @NonNull String pData, @NonNull String pMethod, @NonNull Context context) {

        UserSmsWrapper userWrapper= JSONObject.parseObject(pData, UserSmsWrapper.class);
        String phone=userWrapper.getPhone();
        MobileUserInfo userInfo= new MobileUserInfo();
        userInfo.setMobilePhone(userWrapper.getPhone());
        IDomain domain= UserLoginDomainFactory.getFactory().getDomain(pMethod);
        if(domain == null){
            return;
        }
        domain.execute(pEntity,pResult);
    }
}
