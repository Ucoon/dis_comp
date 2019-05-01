package com.bristua.ft.component.userlogin;

import android.support.annotation.NonNull;
import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IComponent;
import com.bristua.framework.define.annotation.Router;
import com.bristua.framework.define.router.IRouteMeta;
import com.bristua.framework.logger.Logger;
import com.bristua.ft.component.userlogin.business.ActivityStartBusiness;
import com.bristua.ft.component.userlogin.business.GetUserInfoBusiness;
import com.bristua.ft.component.userlogin.business.MobileCodeBusiness;
import com.bristua.ft.component.userlogin.business.MobileLoginBusiness;
import com.bristua.ft.component.userlogin.business.WxLoginBusiness;
import com.bristua.ft.component.userlogin.domain.GetUserInfoDomain;
import com.bristua.ft.component.userlogin.domain.MobileUserDomain;
import com.bristua.ft.component.userlogin.domain.SmsCodeDomain;
import com.bristua.ft.component.userlogin.domain.UserLoginDomainFactory;
import com.bristua.ft.component.userlogin.domain.WxUserDomain;
import com.bristua.ft.component.userlogin.entity.MobileLoginEntity;
import com.bristua.ft.component.userlogin.entity.WxLoginEntity;
import com.bristua.ft.component.userlogin.event.MobileEvent;
import com.bristua.ft.component.userlogin.business.UserLoginBuisiness;
import com.bristua.ft.component.userlogin.repository.UserLoginRepository;
import com.nd.adhoc.framework.business.ManagerFactory;
import com.nd.sdp.android.serviceloader.annotation.Service;
import static com.bristua.ft.component.userlogin.UserLoginConstant.USER_METHOD_INFO;
import static com.bristua.ft.component.userlogin.UserLoginConstant.USER_METHOD_MOBILE;
import static com.bristua.ft.component.userlogin.UserLoginConstant.USER_METHOD_SMSCODE;
import static com.bristua.ft.component.userlogin.UserLoginConstant.USER_METHOD_WX;
import static com.bristua.ft.component.userlogin.UserLoginConstant.WX_METHOD_WAKEN;

/**
 * 用户登录模组
 *
 * @author richsjeson
 */
@Service(IComponent.class)
@Router(UserLoginConstant.USER_LOGIN_MODULE)
public class UserLoginComp implements IComponent {
    private final String TAG=UserLoginComp.class.getName();
    @Override
    public void init() {
        Logger.LOGD(TAG,"init","");
        //todo richsjeson 快核对下模组创建时机吧，别乱创建业务服务层啊
        //执行一些初始化的操作,将服务层进行load
        AppConfig.getInstance().getAppContext().registerBusinessManager(UserLoginConstant.USER_LOGIN_MODULE, new UserLoginBuisiness(UserLoginConstant.USER_LOGIN_MODULE));
    }

    @Override
    public void load() {

        ManagerFactory.getInstance().putFactory(USER_METHOD_MOBILE,new MobileLoginBusiness());
        ManagerFactory.getInstance().putFactory(USER_METHOD_SMSCODE,new MobileCodeBusiness());
        ManagerFactory.getInstance().putFactory(USER_METHOD_WX,new ActivityStartBusiness());
        ManagerFactory.getInstance().putFactory(WX_METHOD_WAKEN,new WxLoginBusiness());
        ManagerFactory.getInstance().putFactory(USER_METHOD_INFO,new GetUserInfoBusiness());


        UserLoginDomainFactory.getFactory().putDomain(USER_METHOD_MOBILE,new MobileUserDomain());
//        UserLoginDomainFactory.getFactory().putDomain(USER_METHOD_WX,new WxUserDomain());
        UserLoginDomainFactory.getFactory().putDomain(USER_METHOD_SMSCODE,new SmsCodeDomain());
        UserLoginDomainFactory.getFactory().putDomain(WX_METHOD_WAKEN,new WxUserDomain());
        UserLoginDomainFactory.getFactory().putDomain(USER_METHOD_INFO,new GetUserInfoDomain());


        UserLoginRepository.getFactory().putEntity(USER_METHOD_MOBILE,new MobileLoginEntity());
//        UserLoginRepository.getFactory().putEntity(USER_METHOD_WX,new WxLoginEntity());
        UserLoginRepository.getFactory().putEntity(WX_METHOD_WAKEN,new WxLoginEntity());

        UserLoginRepository.getFactory().putEntity(USER_METHOD_SMSCODE,new MobileLoginEntity());

    }

    @Override
    public void unload() {
        //模组登录成功后，记得可以执行卸载了 todo richsjeson 是否忘记了卸载业务服务？？？？登录完你还要使用该模组？？开玩笑吧，赶紧回收吧
        //AppConfig.getInstance().getAppContext().unregisterBusinessManager(UserLoginConstant.USER_LOGIN_MODULE);
    }

    @Override
    public void destory() {
        Logger.LOGD(TAG,"destory","");
        //模组登录成功后，记得可以执行卸载了 todo richsjeson 是否忘记了卸载业务服务？？？？
        MobileEvent.getInstance().release();
        UserLoginDomainFactory.getFactory().release();
        UserLoginRepository.getFactory().release();
    }

    @Override
    public void dispatch(@NonNull Object pEvent) {

    }

    @Override
    public void param(@NonNull IRouteMeta pMeta) {
        MobileEvent.newInstance(pMeta.getResult());
        UserLoginBuisiness business= (UserLoginBuisiness) AppConfig.getInstance().getAppContext().getBusinessManager(UserLoginConstant.USER_LOGIN_MODULE);
        business.execute(pMeta.getProtocol(),pMeta.getResult());
    }
}
