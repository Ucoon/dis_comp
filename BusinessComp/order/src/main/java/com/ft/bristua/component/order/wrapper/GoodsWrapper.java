package com.ft.bristua.component.order.wrapper;

public class GoodsWrapper {

    private String goodsId;
    private int buyNum;
    private String productId;
    private String specMsg;

    public String getSpecMsg() {
        return specMsg;
    }

    public void setSpecMsg(String specMsg) {
        this.specMsg = specMsg;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }
}
