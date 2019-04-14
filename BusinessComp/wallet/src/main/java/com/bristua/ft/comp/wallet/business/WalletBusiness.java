package com.bristua.ft.comp.wallet.business;
import android.support.annotation.NonNull;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.system.IBusinessManager;
import com.bristua.ft.comp.wallet.repository.WalletRepository;
import com.nd.adhoc.framework.business.BaseBusiness;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.business.ManagerFactory;
import com.nd.adhoc.framework.entity.IEntity;

import static com.bristua.ft.comp.wallet.WalletConstants.METHOD_WALLET_GETMONEY;

/**
 * @author richsjeson
 * 我的钱包
 */
public class WalletBusiness extends BaseBusiness implements IBusinessManager{

    public WalletBusiness(@NonNull String pMobule) {
        super(pMobule);
    }

    @Override
    public void execute(@NonNull String pProtocol, @NonNull IFlutterResult pResult) {
        super.execute(pProtocol, pResult);
        IManager manager= ManagerFactory.getInstance().getFactory(method);
        if(manager == null){
            pResult.success(null,INNER_ERROR_CODE,errorTip);
        }
        IEntity entity= WalletRepository.getInstance().getEntity(METHOD_WALLET_GETMONEY);
        if(entity == null){
            pResult.success(null,INNER_ERROR_CODE,errorTip);
        }
        manager.execute(pResult,entity,data,method,mContext.getContext());
    }
}
