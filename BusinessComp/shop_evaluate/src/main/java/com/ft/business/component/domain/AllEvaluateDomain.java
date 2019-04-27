package com.ft.business.component.domain;

import android.support.annotation.NonNull;

import com.bristua.framework.define.IFlutterResult;
import com.ft.business.component.service.EvaluateService;
import com.ft.business.component.wrapper.AllEvaluateWrapper;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 商品评价领域
 *
 * @author richsjeson
 */
public class AllEvaluateDomain implements IDomain {

    @Override
    public void execute(@NonNull IEntity iEntity, @NonNull IFlutterResult pResult) {
        AllEvaluateWrapper allEvaluateWrapper = (AllEvaluateWrapper) iEntity.getObjectValue();
        EvaluateService.allEvaluate(pResult, allEvaluateWrapper);
    }
}
