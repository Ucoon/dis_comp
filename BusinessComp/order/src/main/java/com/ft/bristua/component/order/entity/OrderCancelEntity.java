package com.ft.bristua.component.order.entity;

import com.ft.bristua.component.order.wrapper.OrderCancelWrapper;
import com.ft.bristua.component.order.wrapper.OrderSubmitWrapper;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * @author richsjeson
 * 订单提交实体类
 */
public class OrderCancelEntity implements IEntity<OrderCancelWrapper> {

    private OrderCancelWrapper mWrapper;
    @Override
    public void setObjectValue(OrderCancelWrapper pValue) {

        this.mWrapper=pValue;
    }
    @Override
    public OrderCancelWrapper getObjectValue() {
        return this.mWrapper;
    }
}
