package com.bristua.ft.comp.address.business;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.system.IBusinessManager;
import com.bristua.ft.comp.address.repository.AddressRepository;
import com.nd.adhoc.framework.business.BaseBusiness;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.business.ManagerFactory;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * @author richsjeson
 * 地址管理
 */
public class AddressBusiness extends BaseBusiness implements IBusinessManager {

    public AddressBusiness(@NonNull String pMobule) {
        super(pMobule);
    }

    @Override
    public void execute(@NonNull String pProtocol, @NonNull IFlutterResult pResult) {
        super.execute(pProtocol, pResult);
        IManager manager=ManagerFactory.getInstance().getFactory(method);
        if(manager == null){
            pResult.success(null,INNER_ERROR_CODE,errorTip);
        }
        IEntity entity =AddressRepository.getInstance().getEntity(method);
        if(entity == null){
            pResult.success(null,INNER_ERROR_CODE,errorTip);
            return;
        }
        manager.execute(pResult,entity,data,method,mContext.getContext());
    }

}
