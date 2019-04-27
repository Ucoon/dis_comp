package com.ft.business.component.business;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSONObject;
import com.bristua.framework.define.IFlutterResult;
import com.ft.business.component.domain.EvaluateDomainFactory;
import com.ft.business.component.wrapper.GoodsEvaluateWrapper;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 商品评价信息
 *
 * @author richsjeson
 */
public class GoodsEvaluateBusiness implements IManager {
    @Override
    public void execute(@NonNull IFlutterResult pResult, @NonNull IEntity pEntity, @NonNull String pData, @NonNull String pMethod, @NonNull Context context) {
        GoodsEvaluateWrapper goodsEvaluateWrapper = JSONObject.parseObject(pData, GoodsEvaluateWrapper.class);
        pEntity.setObjectValue(goodsEvaluateWrapper);
        IDomain domain = EvaluateDomainFactory.getFactory().getDomain(pMethod);
        if (domain == null) {
            return;
        }
        domain.execute(pEntity, pResult);
    }
}
