package com.ft.business.component.business;

import android.support.annotation.NonNull;

import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.system.IBusinessManager;
import com.ft.business.component.repository.CollectionRepository;
import com.nd.adhoc.framework.business.BaseBusiness;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.business.ManagerFactory;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 设置收藏模块
 *
 * @author richsjeson
 */
public class CollectionBuisiness extends BaseBusiness implements IBusinessManager {

    public CollectionBuisiness(@NonNull String pMobule) {
        super(pMobule);
    }

    @Override
    public void execute(@NonNull String pProtocol, @NonNull IFlutterResult pResult) {
        super.execute(pProtocol, pResult);
        IManager manager = ManagerFactory.getInstance().getFactory(method);
        if (manager == null) {
            pResult.success(null, INNER_ERROR_CODE, errorTip);
        }
        IEntity entity = CollectionRepository.getFactory().getEntity(method);
        manager.execute(pResult, entity, data, method, mContext.getContext());
    }
}
