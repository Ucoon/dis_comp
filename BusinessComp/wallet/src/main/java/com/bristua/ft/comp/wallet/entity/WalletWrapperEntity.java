package com.bristua.ft.comp.wallet.entity;

import com.bristua.ft.comp.wallet.wrapper.WalletWrapper;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * @author richsjeson
 * 对象值
 */
public class WalletWrapperEntity implements IEntity<WalletWrapper> {

    private WalletWrapper mWrapper;
    @Override
    public void setObjectValue(WalletWrapper pValue) {

        this.mWrapper=pValue;
    }

    @Override
    public WalletWrapper getObjectValue() {
        return this.mWrapper;
    }
}
