package com.ft.bristua.component.order.wrapper;

import com.ft.bristua.component.order.entity.GoodsEvaluateEntity;

import java.util.List;

public class OrderCommentWrapper {

    private String orderId;

    private List<GoodsEvaluateEntity> goodsEvaluates;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<GoodsEvaluateEntity> getGoodsEvaluates() {
        return goodsEvaluates;
    }

    public void setGoodsEvaluates(List<GoodsEvaluateEntity> goodsEvaluates) {
        this.goodsEvaluates = goodsEvaluates;
    }


}
