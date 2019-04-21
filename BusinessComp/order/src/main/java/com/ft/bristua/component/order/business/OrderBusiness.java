package com.ft.bristua.component.order.business;

import android.support.annotation.NonNull;

import com.bristua.framework.system.IBusinessManager;
import com.nd.adhoc.framework.business.BaseBusiness;

/**
 * 订单业务服务
 */
public class OrderBusiness extends BaseBusiness implements IBusinessManager {

    public OrderBusiness(@NonNull String pMobule) {
        super(pMobule);
    }
}
