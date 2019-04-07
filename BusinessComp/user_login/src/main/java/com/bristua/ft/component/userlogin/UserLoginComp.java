package com.bristua.ft.component.userlogin;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IComponent;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.define.annotation.Router;
import com.bristua.framework.define.router.IRouteMeta;
import com.bristua.framework.logger.Logger;
import com.bristua.ft.component.userlogin.event.MobileEvent;
import com.bristua.ft.component.userlogin.business.IUserLoginBusiness;
import com.bristua.ft.component.userlogin.business.UserLoginBuisinessImpl;
import com.nd.sdp.android.serviceloader.annotation.Service;

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
        AppConfig.getInstance().getAppContext().registerBusinessManager(UserLoginConstant.USER_LOGIN_MODULE, new UserLoginBuisinessImpl());
    }

    @Override
    public void load() {
        Logger.LOGD(TAG,"load","");
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
        //AppConfig.getInstance().getAppContext().unregisterBusinessManager(UserLoginConstant.USER_LOGIN_MODULE);
        MobileEvent.getInstance().release();
    }

    @Override
    public void dispatch(@NonNull Object pEvent) {

    }

    @Override
    public void param(@NonNull IRouteMeta pMeta) {
        Logger.LOGD(TAG,"param","");
        IFlutterResult mResult = pMeta.getResult();
        if (mResult == null) {
            return;
        }
        //获取参数
        String params = pMeta.getProtocol();
        if (TextUtils.isEmpty(params)) {
            return;
        }
        //执行用户登录模块
        IUserLoginBusiness userLoginBusiness= (IUserLoginBusiness) AppConfig.getInstance().getAppContext().getBusinessManager(UserLoginConstant.USER_LOGIN_MODULE);
        userLoginBusiness.exec(params,mResult);
    }
}
