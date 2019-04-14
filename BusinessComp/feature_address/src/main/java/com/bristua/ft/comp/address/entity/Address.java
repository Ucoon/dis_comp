package com.bristua.ft.comp.address.entity;

/**
 * @author richsjeson
 * 地址类
 */
public class Address {
    /**
     * 手机号
     */
    private String mobilePhone;
    /**
     * 姓名
     */
    private String realName;
    /**
     * 地址信息
     */
    private String addresses;
    /**
     * 附加地址信息
     */
    private String atAddress;

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAddress() {
        return addresses;
    }

    public void setAddress(String address) {
        this.addresses = address;
    }

    public String getAtAddress() {
        return atAddress;
    }

    public void setAtAddress(String atAddress) {
        this.atAddress = atAddress;
    }
}
