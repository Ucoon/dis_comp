package com.ft.bristua.component.order.business;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.alibaba.fastjson.JSON;
import com.bristua.framework.define.IFlutterResult;
import com.ft.bristua.component.order.domain.DomainFactory;
import com.ft.bristua.component.order.wrapper.OrderCommentWrapper;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * @author richsjeson
 * 提交订单
 */
public class OrderCommentBusiness implements IManager {
    @Override
    public void execute(@NonNull IFlutterResult pResult, @Nullable IEntity pEntity, @NonNull String pData, @NonNull String pMethod, @NonNull Context pContext) {
        OrderCommentWrapper wrapper= JSON.parseObject(pData,OrderCommentWrapper.class);
        pEntity.setObjectValue(wrapper);
        IDomain domain= DomainFactory.getInstance().getDomain(pMethod);
        domain.execute(pEntity,pResult);
    }
}
