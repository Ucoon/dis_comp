package com.bristua.ft.comp.wallet.business;
import android.content.Context;
import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSONObject;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.comp.wallet.domain.WalletDomainFactory;
import com.bristua.ft.comp.wallet.wrapper.WalletWrapper;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * @author richsjeson
 * 获取用户余额
 */
public class QueryWalletBusiness implements IManager {
    @Override
    public void execute(@NonNull IFlutterResult pResult, @NonNull IEntity pEntity, @NonNull String pData, @NonNull String pMethod, @NonNull Context pContext) {

        WalletWrapper wrapper= JSONObject.parseObject(pData,WalletWrapper.class);
        pEntity.setObjectValue(wrapper);
        //设置wrapper
        IDomain domain= WalletDomainFactory.getInstance().getDomain(pMethod);
        domain.execute(pEntity,pResult);
    }
}
