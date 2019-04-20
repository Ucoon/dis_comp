package com.bristua.ft.component.userpay.business;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSONObject;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.component.userpay.domain.UserPayDomainFactory;
import com.bristua.ft.component.userpay.wrapper.WXPayWrapper;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 用户微信支付
 *
 * @author richsjeson
 */
public class WXPayBusiness implements IManager {
    @Override
    public void execute(@NonNull IFlutterResult pResult, @NonNull IEntity pEntity, @NonNull String pData, @NonNull String pMethod, @NonNull Context context) {
        WXPayWrapper userWrapper = JSONObject.parseObject(pData, WXPayWrapper.class);
        pEntity.setObjectValue(userWrapper);
        IDomain domain = UserPayDomainFactory.getFactory().getDomain(pMethod);
        if (domain == null) {
            return;
        }
        domain.execute(pEntity, pResult);
    }
}
