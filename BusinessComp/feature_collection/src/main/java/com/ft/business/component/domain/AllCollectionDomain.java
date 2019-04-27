package com.ft.business.component.domain;

import android.support.annotation.NonNull;

import com.bristua.framework.define.IFlutterResult;
import com.ft.business.component.service.CollectionService;
import com.ft.business.component.wrapper.AllCollectionWrapper;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

public class AllCollectionDomain implements IDomain {

    @Override
    public void execute(@NonNull IEntity iEntity, @NonNull IFlutterResult pResult) {
        AllCollectionWrapper allCollectionWrapper = (AllCollectionWrapper) iEntity.getObjectValue();
        CollectionService.allCollection(pResult, allCollectionWrapper);
    }
}
