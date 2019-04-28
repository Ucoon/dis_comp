package com.bristua.ft.comp.rebate.business;

import android.support.annotation.NonNull;

import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.system.IBusinessManager;
import com.bristua.ft.comp.rebate.repository.RebateRepository;
import com.nd.adhoc.framework.business.BaseBusiness;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.business.ManagerFactory;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * @author richsjeson
 * 返现业务组件
 */
public class RebateBusiness extends BaseBusiness implements IBusinessManager {

    public RebateBusiness(@NonNull String pMobule) {
        super(pMobule);
    }
    @Override
    public void execute(@NonNull String pProtocol, @NonNull IFlutterResult pResult) {
        super.execute(pProtocol, pResult);
        IManager manager= ManagerFactory.getInstance().getFactory(method);
        if(manager == null){
            pResult.success(null,INNER_ERROR_CODE,errorTip);
        }
        IEntity entity = RebateRepository.getInstance().getEntity(method);
        manager.execute(pResult,entity,data,method,mContext.getContext());
    }
}
