package com.ft.business.component.userinfo;


import android.support.annotation.NonNull;

import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IComponent;
import com.bristua.framework.define.annotation.Router;
import com.bristua.framework.define.router.IRouteMeta;
import com.bristua.framework.logger.Logger;
import com.ft.business.component.userinfo.business.UserInfoBuisiness;
import com.ft.business.component.userinfo.business.WXInfoBusiness;
import com.ft.business.component.userinfo.domain.UserInfoDomainFactory;
import com.ft.business.component.userinfo.domain.WXInfoDomain;
import com.ft.business.component.userinfo.entity.WXInfoEntity;
import com.ft.business.component.userinfo.repository.UserInfoRepository;
import com.nd.adhoc.framework.business.ManagerFactory;
import com.nd.sdp.android.serviceloader.annotation.Service;

/**
 * 用户信息模组
 *
 * @author richsjeson
 */
@Service(IComponent.class)
@Router(UserInfoConstant.USER_INFO)
public class UserInfoComp implements IComponent {
    private final String TAG = UserInfoComp.class.getName();

    @Override
    public void init() {
        Logger.LOGD(TAG, "init", "");
        //todo richsjeson 快核对下模组创建时机吧，别乱创建业务服务层啊
        //执行一些初始化的操作,将服务层进行load
        AppConfig.getInstance().getAppContext().registerBusinessManager(UserInfoConstant.USER_INFO, new UserInfoBuisiness(UserInfoConstant.USER_INFO));
    }

    @Override
    public void load() {
        ManagerFactory.getInstance().putFactory(UserInfoConstant.USER_WX_INFO, new WXInfoBusiness());
        UserInfoDomainFactory.getFactory().putDomain(UserInfoConstant.USER_WX_INFO, new WXInfoDomain());
        UserInfoRepository.getFactory().putEntity(UserInfoConstant.USER_WX_INFO, new WXInfoEntity());
    }

    @Override
    public void unload() {
        //模组登录成功后，记得可以执行卸载了 todo richsjeson 是否忘记了卸载业务服务？？？？登录完你还要使用该模组？？开玩笑吧，赶紧回收吧
        //AppConfig.getInstance().getAppContext().unregisterBusinessManager(UserLoginConstant.USER_LOGIN_MODULE);
    }

    @Override
    public void destory() {
        Logger.LOGD(TAG, "destory", "");
        UserInfoDomainFactory.getFactory().release();
        UserInfoRepository.getFactory().release();
    }

    @Override
    public void dispatch(@NonNull Object pEvent) {

    }

    @Override
    public void param(@NonNull IRouteMeta pMeta) {
        UserInfoBuisiness business = (UserInfoBuisiness) AppConfig.getInstance().getAppContext().getBusinessManager(UserInfoConstant.USER_INFO);
        business.execute(pMeta.getProtocol(), pMeta.getResult());
    }
}
