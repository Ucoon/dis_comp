package com.bristua.ft.component.userpay;


import android.support.annotation.NonNull;

import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IComponent;
import com.bristua.framework.define.annotation.Router;
import com.bristua.framework.define.router.IRouteMeta;
import com.bristua.framework.logger.Logger;
import com.bristua.ft.component.userpay.business.UserPayBuisiness;
import com.bristua.ft.component.userpay.business.WXPayBusiness;
import com.bristua.ft.component.userpay.domain.UserPayDomainFactory;
import com.bristua.ft.component.userpay.domain.WXPayDomain;
import com.bristua.ft.component.userpay.entity.WXPayEntity;
import com.bristua.ft.component.userpay.event.MobileEvent;
import com.bristua.ft.component.userpay.repository.UserPayRepository;
import com.nd.adhoc.framework.business.ManagerFactory;
import com.nd.sdp.android.serviceloader.annotation.Service;

/**
 * 用户登录模组
 *
 * @author richsjeson
 */
@Service(IComponent.class)
@Router(UserPayConstant.USER_PAY)
public class UserPayComp implements IComponent {
    private final String TAG = UserPayComp.class.getName();

    @Override
    public void init() {
        Logger.LOGD(TAG, "init", "");
        //todo richsjeson 快核对下模组创建时机吧，别乱创建业务服务层啊
        //执行一些初始化的操作,将服务层进行load
        AppConfig.getInstance().getAppContext().registerBusinessManager(UserPayConstant.USER_PAY, new UserPayBuisiness(UserPayConstant.USER_PAY));
    }

    @Override
    public void load() {
        ManagerFactory.getInstance().putFactory(UserPayConstant.USER_WX_PAY, new WXPayBusiness());
        UserPayDomainFactory.getFactory().putDomain(UserPayConstant.USER_WX_PAY, new WXPayDomain());
        UserPayRepository.getFactory().putEntity(UserPayConstant.USER_WX_PAY, new WXPayEntity());
    }

    @Override
    public void unload() {
        //模组登录成功后，记得可以执行卸载了 todo richsjeson 是否忘记了卸载业务服务？？？？登录完你还要使用该模组？？开玩笑吧，赶紧回收吧
        //AppConfig.getInstance().getAppContext().unregisterBusinessManager(UserLoginConstant.USER_LOGIN_MODULE);
    }

    @Override
    public void destory() {
        Logger.LOGD(TAG, "destory", "");
        MobileEvent.getInstance().release();
        UserPayDomainFactory.getFactory().release();
        UserPayRepository.getFactory().release();
    }

    @Override
    public void dispatch(@NonNull Object pEvent) {

    }

    @Override
    public void param(@NonNull IRouteMeta pMeta) {
        MobileEvent.newInstance(pMeta.getResult());
        UserPayBuisiness business = (UserPayBuisiness) AppConfig.getInstance().getAppContext().getBusinessManager(UserPayConstant.USER_PAY);
        business.execute(pMeta.getProtocol(), pMeta.getResult());
    }
}
