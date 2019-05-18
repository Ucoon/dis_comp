package com.ft.business.component.domain;

import android.support.annotation.NonNull;

import com.bristua.framework.define.IFlutterResult;
import com.ft.business.component.service.CollectionService;
import com.ft.business.component.wrapper.GoodsCollectionWrapper;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

public class CancelCollectionDomain implements IDomain {

    @Override
    public void execute(@NonNull IEntity iEntity, @NonNull IFlutterResult pResult) {
        GoodsCollectionWrapper goodsCollectionWrapper = (GoodsCollectionWrapper) iEntity.getObjectValue();
        CollectionService.cancelCollection(pResult, goodsCollectionWrapper);
    }
}
