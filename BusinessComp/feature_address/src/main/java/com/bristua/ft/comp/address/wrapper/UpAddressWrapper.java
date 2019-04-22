package com.bristua.ft.comp.address.wrapper;

import java.io.Serializable;

/**
 * @author richsjeson
 * 地址入参
 */
public class UpAddressWrapper extends  AddressWrapper  implements Serializable {

    private String userAddressId;

    public String getUserAddressId() {
        return userAddressId;
    }

    public void setUserAddressId(String userAddressId) {
        this.userAddressId = userAddressId;
    }
}
