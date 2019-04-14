package com.bristua.ft.comp.rebate.business;
import android.content.Context;
import android.support.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.comp.rebate.domain.DomainFactory;
import com.bristua.ft.comp.rebate.wrapper.RebateWrapper;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;
/**
 * 获取返现排名
 * @author richsjeson
 */
public class FindRebateBusiness implements IManager {
    @Override
    public void execute(@NonNull IFlutterResult pResult, @NonNull IEntity pEntity, @NonNull String pData, @NonNull String pMethod, @NonNull Context pContext) {
        //执行数据获取的操作
        RebateWrapper rebateWrapper= JSONObject.parseObject(pData, RebateWrapper.class);
        if(rebateWrapper == null){
            return;
        }
        pEntity.setObjectValue(rebateWrapper);
        IDomain domain= DomainFactory.getInstance().getDomain(pMethod);
        domain.execute(pEntity,pResult);
    }
}
