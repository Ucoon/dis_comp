package com.bristua.ft.component.userlogin.business;
import android.content.Context;
import android.support.annotation.NonNull;

import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.system.IBusinessManager;
import com.bristua.ft.component.userlogin.entity.MobileLoginEntity;
import com.bristua.ft.component.userlogin.repository.UserLoginRepository;
import com.nd.adhoc.framework.business.BaseBusiness;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.business.ManagerFactory;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 设置用户登录模块
 *
 * @author richsjeson
 */
public class UserLoginBuisiness extends BaseBusiness implements IBusinessManager {

    public UserLoginBuisiness(@NonNull String pMobule) {
        super(pMobule);
    }

    @Override
    public void execute(@NonNull String pProtocol, @NonNull IFlutterResult pResult) {
        super.execute(pProtocol, pResult);
        IManager manager= ManagerFactory.getInstance().getFactory(method);
        if(manager == null){
            pResult.success(null,INNER_ERROR_CODE,errorTip);
        }
        IEntity entity=UserLoginRepository.getFactory().getEntity(method);
        manager.execute(pResult,entity,data,method,mContext.getContext());
    }
}
