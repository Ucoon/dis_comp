package com.ft.bristua.component.order.domain;

import android.support.annotation.NonNull;

import com.bristua.framework.define.IFlutterResult;
import com.ft.bristua.component.order.entity.OrderSubmitEntity;
import com.ft.bristua.component.order.service.OrderSubmitService;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * @author richsjeson
 * 订单提交域
 */
public class OrderSubmitDomain implements IDomain {
    @Override
    public void execute(@NonNull IEntity pEntity, @NonNull IFlutterResult pResult) {
        OrderSubmitEntity entity= (OrderSubmitEntity) pEntity;
        OrderSubmitService.submit(entity.getObjectValue(),pResult);
    }
}
