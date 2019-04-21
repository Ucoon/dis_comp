package com.ft.bristua.component.order.wrapper;

import java.util.List;

public class OrderSubmitWrapper {

    private String userAddressId;

    private List<GoodsWrapper> goods;

    private int freight;

    public String getUserAddressId() {
        return userAddressId;
    }

    public void setUserAddressId(String userAddressId) {
        this.userAddressId = userAddressId;
    }

    public List<GoodsWrapper> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsWrapper> goods) {
        this.goods = goods;
    }

    public int getFreight() {
        return freight;
    }

    public void setFreight(int freight) {
        this.freight = freight;
    }
}
