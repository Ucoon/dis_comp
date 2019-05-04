package com.ft.bristua.component.order;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IComponent;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.define.annotation.Router;
import com.bristua.framework.define.router.IRouteMeta;
import com.ft.bristua.component.order.business.OrderBusiness;
import com.ft.bristua.component.order.business.OrderCancelBusiness;
import com.ft.bristua.component.order.business.OrderDetailBusiness;
import com.ft.bristua.component.order.business.OrderSubmitBusiness;
import com.ft.bristua.component.order.domain.DomainFactory;
import com.ft.bristua.component.order.domain.OrderCancelDomain;
import com.ft.bristua.component.order.domain.OrderSubmitDomain;
import com.ft.bristua.component.order.entity.OrderCancelEntity;
import com.ft.bristua.component.order.entity.OrderSubmitEntity;
import com.ft.bristua.component.order.repository.OrderRepository;
import com.nd.adhoc.framework.BaseComponent;
import com.nd.adhoc.framework.business.ManagerFactory;
import com.nd.sdp.android.serviceloader.annotation.Service;

/**
 * 订单模组组件 包含订单详情和提交订单
 * @author richsjeson
 */
@Service(IComponent.class)
@Router(OrderConstants.ORDER_MODULE)
public class OrderComponent extends BaseComponent implements IComponent {

    @Override
    public void init() {

        AppConfig.getInstance().getAppContext().registerBusinessManager(OrderConstants.ORDER_MODULE,new OrderBusiness(OrderConstants.ORDER_MODULE));
    }

    @Override
    public void load() {
        ManagerFactory.getInstance().putFactory(OrderConstants.METHOD_ORDER_SUBMIT,new OrderSubmitBusiness());
        ManagerFactory.getInstance().putFactory(OrderConstants.METGOD_ORDER_DETAIL,new OrderDetailBusiness());
        ManagerFactory.getInstance().putFactory(OrderConstants.METHOD_ORDER_CANCEL,new OrderCancelBusiness());

        //添加实体域--订单提交
        OrderRepository.getInstance().putEntity(OrderConstants.METHOD_ORDER_SUBMIT,new OrderSubmitEntity());
        DomainFactory.getInstance().putDomain(OrderConstants.METHOD_ORDER_SUBMIT,new OrderSubmitDomain());

        OrderRepository.getInstance().putEntity(OrderConstants.METHOD_ORDER_CANCEL,new OrderCancelEntity());
        DomainFactory.getInstance().putDomain(OrderConstants.METHOD_ORDER_CANCEL,new OrderCancelDomain());
    }

    @Override
    public void unload() {

    }

    @Override
    public void destory() {
        ManagerFactory.getInstance().release();
        DomainFactory.getInstance().release();
        OrderRepository.getInstance().release();
    }

    @Override
    public void dispatch(@Nullable Object pEvent) {

    }

    @Override
    public void param(@Nullable IRouteMeta pMeta) {

        OrderBusiness business= (OrderBusiness) AppConfig.getInstance().getAppContext().getBusinessManager(OrderConstants.ORDER_MODULE);
        business.execute(pMeta.getProtocol(),pMeta.getResult());
    }

}
