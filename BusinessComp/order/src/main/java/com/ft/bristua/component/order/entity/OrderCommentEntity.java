package com.ft.bristua.component.order.entity;

import com.ft.bristua.component.order.wrapper.OrderCommentWrapper;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * @author richsjeson
 * 订单提交实体类
 */
public class OrderCommentEntity implements IEntity<OrderCommentWrapper> {

    private OrderCommentWrapper mWrapper;
    @Override
    public void setObjectValue(OrderCommentWrapper pValue) {

        this.mWrapper=pValue;
    }
    @Override
    public OrderCommentWrapper getObjectValue() {
        return this.mWrapper;
    }
}
