package com.ft.business.component.userinfo.business;

import android.support.annotation.NonNull;

import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.system.IBusinessManager;
import com.ft.business.component.userinfo.repository.UserInfoRepository;
import com.nd.adhoc.framework.business.BaseBusiness;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.business.ManagerFactory;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 设置用户信息模块
 *
 * @author richsjeson
 */
public class UserInfoBuisiness extends BaseBusiness implements IBusinessManager {

    public UserInfoBuisiness(@NonNull String pMobule) {
        super(pMobule);
    }

    @Override
    public void execute(@NonNull String pProtocol, @NonNull IFlutterResult pResult) {
        super.execute(pProtocol, pResult);
        IManager manager = ManagerFactory.getInstance().getFactory(method);
        if (manager == null) {
            pResult.success(null, INNER_ERROR_CODE, errorTip);
        }
        IEntity entity = UserInfoRepository.getFactory().getEntity(method);
        manager.execute(pResult, entity, data, method, mContext.getContext());
    }
}
