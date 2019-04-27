package com.ft.business.component.business;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSONObject;
import com.bristua.framework.define.IFlutterResult;
import com.ft.business.component.domain.CollectionDomainFactory;
import com.ft.business.component.wrapper.GoodsCollectionWrapper;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

public class GoodsCollectionBusiness implements IManager {
    @Override
    public void execute(@NonNull IFlutterResult pResult, @NonNull IEntity pEntity, @NonNull String pData, @NonNull String pMethod, @NonNull Context context) {
        GoodsCollectionWrapper goodsEvaluateWrapper = JSONObject.parseObject(pData, GoodsCollectionWrapper.class);
        pEntity.setObjectValue(goodsEvaluateWrapper);
        IDomain domain = CollectionDomainFactory.getFactory().getDomain(pMethod);
        if (domain == null) {
            return;
        }
        domain.execute(pEntity, pResult);
    }
}