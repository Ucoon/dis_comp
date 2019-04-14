package com.bristua.ft.comp.wallet.domain;

import android.support.annotation.NonNull;

import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.comp.wallet.service.QueryWalletService;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * @author richsjeson
 * 查询用户当前的钱包
 */
public class UserWalletDomain implements IDomain {
    @Override
    public void execute(@NonNull IEntity pEntity, @NonNull IFlutterResult pResult) {
        QueryWalletService.queryUserWallet(pEntity,pResult);
    }
}
