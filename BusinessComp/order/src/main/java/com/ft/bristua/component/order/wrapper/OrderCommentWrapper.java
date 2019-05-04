package com.ft.bristua.component.order.wrapper;

import com.ft.bristua.component.order.entity.GoodsEvaluateEntity;

import java.util.List;

public class OrderCommentWrapper {

    private String orderId;

    private List<GoodsEvaluateEntity> goods;

    public OrderCommentWrapper(String orderId, List<GoodsEvaluateEntity> goods) {
        this.orderId = orderId;
        this.goods = goods;
    }
}
