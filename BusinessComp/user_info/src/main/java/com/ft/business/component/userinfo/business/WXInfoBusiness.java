package com.ft.business.component.userinfo.business;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSONObject;
import com.bristua.framework.define.IFlutterResult;
import com.ft.business.component.userinfo.domain.UserInfoDomainFactory;
import com.ft.business.component.userinfo.wrapper.WXInfoWrapper;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 微信用户信息
 *
 * @author richsjeson
 */
public class WXInfoBusiness implements IManager {
    @Override
    public void execute(@NonNull IFlutterResult pResult, @NonNull IEntity pEntity, @NonNull String pData, @NonNull String pMethod, @NonNull Context context) {
        WXInfoWrapper wxInfoWrapper = JSONObject.parseObject(pData, WXInfoWrapper.class);
        pEntity.setObjectValue(wxInfoWrapper);
        IDomain domain = UserInfoDomainFactory.getFactory().getDomain(pMethod);
        if (domain == null) {
            return;
        }
        domain.execute(pEntity, pResult);
    }
}
