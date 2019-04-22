package com.bristua.ft.comp.address.wrapper;

import java.io.Serializable;

/**
 * @author richsjeson
 * 地址入参
 */
public class AddressWrapper implements Serializable {
    /**
     * 手机号
     */
    private String receivePhone;
    /**
     * 姓名
     */
    private String receiveGoodsName;
    /**
     * 地址信息
     */
    private String receiveAddressName;

    private int status;

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getReceiveGoodsName() {
        return receiveGoodsName;
    }

    public void setReceiveGoodsName(String receiveGoodsName) {
        this.receiveGoodsName = receiveGoodsName;
    }

    public String getReceiveAddressName() {
        return receiveAddressName;
    }

    public void setReceiveAddressName(String receiveAddressName) {
        this.receiveAddressName = receiveAddressName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
