package com.ft.bristua.component.order.wrapper;

import com.ft.bristua.component.order.entity.GoodsEvaluateEntity;

import java.util.List;

public class OrderCommentWrapper {

    private String orderId;

    private List<GoodsEvaluateEntity> goods;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<GoodsEvaluateEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsEvaluateEntity> goods) {
        this.goods = goods;
    }

    public OrderCommentWrapper(String orderId, List<GoodsEvaluateEntity> goods) {
        this.orderId = orderId;
        this.goods = goods;
    }
}
