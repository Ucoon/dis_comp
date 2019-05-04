package com.ft.bristua.component.order.domain;

import android.support.annotation.NonNull;

import com.bristua.framework.define.IFlutterResult;
import com.ft.bristua.component.order.entity.OrderCommentEntity;
import com.ft.bristua.component.order.service.OrderCommentService;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * @author richsjeson
 * 订单提交域
 */
public class OrderCommentDomain implements IDomain {
    @Override
    public void execute(@NonNull IEntity pEntity, @NonNull IFlutterResult pResult) {
        OrderCommentEntity entity= (OrderCommentEntity) pEntity;
        OrderCommentService.submit(entity.getObjectValue(),pResult);
    }
}
