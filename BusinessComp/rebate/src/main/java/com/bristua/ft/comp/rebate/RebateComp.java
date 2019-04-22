package com.bristua.ft.comp.rebate;

import android.support.annotation.Nullable;

import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IComponent;
import com.bristua.framework.define.annotation.Router;
import com.bristua.framework.define.router.IRouteMeta;
import com.bristua.ft.comp.rebate.business.FindRebateBusiness;
import com.bristua.ft.comp.rebate.business.RebateBusiness;
import com.bristua.ft.comp.rebate.business.UserConsumeBusiness;
import com.bristua.ft.comp.rebate.domain.DomainFactory;
import com.bristua.ft.comp.rebate.domain.FindRebatesDomain;
import com.bristua.ft.comp.rebate.domain.UserConsumeDomain;
import com.bristua.ft.comp.rebate.entity.RebateEntity;
import com.bristua.ft.comp.rebate.repository.RebateRepository;
import com.nd.adhoc.framework.business.ManagerFactory;
import com.nd.sdp.android.serviceloader.annotation.Service;

/**
 * @author richsjeson
 * 返现组件
 */
@Service(IComponent.class)
@Router(RebateConstants.MODULE)
public class RebateComp implements IComponent {
    @Override
    public void init() {
        AppConfig.getInstance().getAppContext().registerBusinessManager(RebateConstants.MODULE,new RebateBusiness(RebateConstants.MODULE));
    }

    @Override
    public void load() {

        ManagerFactory.getInstance().putFactory(RebateConstants.METHOD_REBATE_FINDALL,new FindRebateBusiness());
        ManagerFactory.getInstance().putFactory(RebateConstants.METHOD_REBATE_USERCONSUME,new UserConsumeBusiness());

        DomainFactory.getInstance().putDomain(RebateConstants.METHOD_REBATE_FINDALL,new FindRebatesDomain());
        DomainFactory.getInstance().putDomain(RebateConstants.METHOD_REBATE_USERCONSUME,new UserConsumeDomain());

        RebateRepository.getInstance().putEntity(RebateConstants.METHOD_REBATE_FINDALL,new RebateEntity());

    }

    @Override
    public void unload() {

    }

    @Override
    public void destory() {
        DomainFactory.getInstance().release();
        RebateRepository.getInstance().release();
        ManagerFactory.getInstance().release();
    }

    @Override
    public void dispatch(@Nullable Object pEvent) {

    }

    @Override
    public void param(@Nullable IRouteMeta pMeta) {
        RebateBusiness business= (RebateBusiness) AppConfig.getInstance().getAppContext().getBusinessManager(RebateConstants.MODULE);
        business.execute(pMeta.getProtocol(),pMeta.getResult());
    }
}
