package com.ft.business.component.business;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSONObject;
import com.bristua.framework.define.IFlutterResult;
import com.ft.business.component.domain.EvaluateDomainFactory;
import com.ft.business.component.wrapper.AllEvaluateWrapper;
import com.ft.business.component.wrapper.GoodsEvaluateWrapper;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 所有评价信息
 *
 * @author richsjeson
 */
public class AllEvaluateBusiness implements IManager {
    @Override
    public void execute(@NonNull IFlutterResult pResult, @NonNull IEntity pEntity, @NonNull String pData, @NonNull String pMethod, @NonNull Context context) {
        AllEvaluateWrapper wxInfoWrapper = JSONObject.parseObject(pData, AllEvaluateWrapper.class);
        pEntity.setObjectValue(wxInfoWrapper);
        IDomain domain = EvaluateDomainFactory.getFactory().getDomain(pMethod);
        if (domain == null) {
            return;
        }
        domain.execute(pEntity, pResult);
    }
}
