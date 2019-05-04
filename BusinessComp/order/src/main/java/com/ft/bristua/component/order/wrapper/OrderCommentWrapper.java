package com.ft.bristua.component.order.wrapper;

import java.util.List;

public class OrderCommentWrapper {

    private String orderId;

    private List<GoodsEvaluateWapper> goodsEvaluates;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<GoodsEvaluateWapper> getGoodsEvaluates() {
        return goodsEvaluates;
    }

    public void setGoodsEvaluates(List<GoodsEvaluateWapper> goodsEvaluates) {
        this.goodsEvaluates = goodsEvaluates;
    }


}
