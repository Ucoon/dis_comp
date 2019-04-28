package com.bristua.ft.comp.rebate.domain;

import android.support.annotation.NonNull;

import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.comp.rebate.entity.RebateEntity;
import com.bristua.ft.comp.rebate.service.FindRebatesService;
import com.bristua.ft.comp.rebate.wrapper.RebateWrapper;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * @author richsjeson
 * 获取返现列表的统计信息
 */
public class FindRebatesDomain implements IDomain {
    @Override
    public void execute(@NonNull IEntity pEntity, @NonNull IFlutterResult pResult) {
        RebateEntity rebateEntity= (RebateEntity) pEntity;
        RebateWrapper rebateWrapper=rebateEntity.getObjectValue();
        FindRebatesService.findIntegral(rebateWrapper.getPageSize(),rebateWrapper.getPageNo(),pResult);
    }
}
