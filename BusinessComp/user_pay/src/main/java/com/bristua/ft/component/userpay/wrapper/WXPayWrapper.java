package com.bristua.ft.component.userpay.wrapper;

public class WXPayWrapper {
    private String tradeOrderId;//交易订单号
    private String spbillCreateIp;//终商IP
    private String goodsDesc;//商品描述
    private String tradeType;//交易类型
    private String attach;//附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据

    public String getTradeOrderId() {
        return tradeOrderId;
    }

    public void setTradeOrderId(String tradeOrderId) {
        this.tradeOrderId = tradeOrderId;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }
}
