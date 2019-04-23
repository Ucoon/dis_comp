package com.ft.bristua.component.order.business;

import android.support.annotation.NonNull;

import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.system.IBusinessManager;
import com.ft.bristua.component.order.repository.OrderRepository;
import com.nd.adhoc.framework.business.BaseBusiness;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.business.ManagerFactory;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 订单业务服务
 */
public class OrderBusiness extends BaseBusiness implements IBusinessManager {

    public OrderBusiness(@NonNull String pMobule) {
        super(pMobule);
    }

    @Override
    public void execute(@NonNull String pProtocol, @NonNull IFlutterResult pResult) {
        super.execute(pProtocol, pResult);
        IManager manager= ManagerFactory.getInstance().getFactory(method);
        if(manager == null){
            pResult.success(null,INNER_ERROR_CODE,errorTip);
        }
        IEntity entity= OrderRepository.getInstance().getEntity(method);
        manager.execute(pResult,entity,data,method,mContext.getContext());
    }
}
