package com.bristua.ft.comp.address;


import android.support.annotation.Nullable;

import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IComponent;
import com.bristua.framework.define.annotation.Router;
import com.bristua.framework.define.router.IRouteMeta;
import com.bristua.ft.comp.address.business.AddBusiness;
import com.bristua.ft.comp.address.business.AddressBusiness;
import com.bristua.ft.comp.address.business.DelBusiness;
import com.bristua.ft.comp.address.business.FindBusiness;
import com.bristua.ft.comp.address.domain.AddressAddDomain;
import com.bristua.ft.comp.address.domain.AddressDeleteDomain;
import com.bristua.ft.comp.address.domain.DomainFactory;
import com.bristua.ft.comp.address.domain.FindAddressDomain;
import com.bristua.ft.comp.address.entity.AddressEntity;
import com.bristua.ft.comp.address.repository.AddressRepository;
import com.nd.adhoc.framework.BaseComponent;
import com.nd.adhoc.framework.business.ManagerFactory;
import com.nd.sdp.android.serviceloader.annotation.Service;

@Service(IComponent.class)
@Router(AddressConstant.MODULE)
public class AddressComp extends BaseComponent {
    @Override
    public void init() {
        AppConfig.getInstance().getAppContext().registerBusinessManager(AddressConstant.MODULE,  new AddressBusiness(AddressConstant.MODULE));
    }

    @Override
    public void load() {
        AddressRepository.getInstance().putEntity(AddressConstant.MODULE,new AddressEntity());
        ManagerFactory.getInstance().putFactory(AddressConstant.METHOD_ADD,new AddBusiness());
        ManagerFactory.getInstance().putFactory(AddressConstant.METHOD_DEL,new DelBusiness());
        ManagerFactory.getInstance().putFactory(AddressConstant.METHOD_FOUND,new FindBusiness());

        DomainFactory.getInstance().putDomain(AddressConstant.METHOD_ADD,new AddressAddDomain());
        DomainFactory.getInstance().putDomain(AddressConstant.METHOD_DEL,new AddressDeleteDomain());
        DomainFactory.getInstance().putDomain(AddressConstant.METHOD_FOUND,new FindAddressDomain());
    }

    @Override
    public void unload() {

    }

    @Override
    public void destory() {
        ManagerFactory.getInstance().release();
        DomainFactory.getInstance().relase();
        AddressRepository.getInstance().release();
    }

    @Override
    public void dispatch(@Nullable Object pEvent) {

    }

    @Override
    public void param(@Nullable IRouteMeta pMeta) {
        AddressBusiness business= (AddressBusiness) AppConfig.getInstance().getAppContext().getBusinessManager(AddressConstant.MODULE);
        business.execute(pMeta.getProtocol(),pMeta.getResult());
    }

}
