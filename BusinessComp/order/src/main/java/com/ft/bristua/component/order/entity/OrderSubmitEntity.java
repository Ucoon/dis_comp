package com.ft.bristua.component.order.entity;

import com.ft.bristua.component.order.wrapper.OrderSubmitWrapper;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * @author richsjeson
 * 订单提交实体类
 */
public class OrderSubmitEntity implements IEntity<OrderSubmitWrapper> {

    private OrderSubmitWrapper mWrapper;
    @Override
    public void setObjectValue(OrderSubmitWrapper pValue) {

        this.mWrapper=pValue;
    }
    @Override
    public OrderSubmitWrapper getObjectValue() {
        return this.mWrapper;
    }
}
