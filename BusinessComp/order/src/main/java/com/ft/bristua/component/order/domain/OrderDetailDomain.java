package com.ft.bristua.component.order.domain;

import android.support.annotation.NonNull;

import com.bristua.framework.define.IFlutterResult;
import com.ft.bristua.component.order.entity.OrderCancelEntity;
import com.ft.bristua.component.order.service.OrderDetailService;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * @author richsjeson
 * 订单提交域
 */
public class OrderDetailDomain implements IDomain {
    @Override
    public void execute(@NonNull IEntity pEntity, @NonNull IFlutterResult pResult) {
        OrderCancelEntity entity= (OrderCancelEntity) pEntity;
        OrderDetailService.detail(entity.getObjectValue(),pResult);
    }
}
