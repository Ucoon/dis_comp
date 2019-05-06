package com.ft.bristua.comp.session;

import android.support.annotation.Nullable;

import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IComponent;
import com.bristua.framework.define.annotation.Router;
import com.bristua.framework.define.router.IRouteMeta;
import com.ft.bristua.comp.session.business.SessionBusiness;
import com.nd.sdp.android.serviceloader.annotation.Service;

@Service(IComponent.class)
@Router(SessionConstants.MODULE)
public class SessionComp implements IComponent {
    @Override
    public void init() {
        //此处初始化即可了。不要考虑其它的了
        AppConfig.getInstance().getAppContext().registerBusinessManager(SessionConstants.MODULE, new SessionBusiness());
    }

    @Override
    public void load() {

    }

    @Override
    public void unload() {

    }

    @Override
    public void destory() {

    }

    @Override
    public void dispatch(@Nullable Object pEvent) {

    }

    @Override
    public void param(@Nullable IRouteMeta pMeta) {
        SessionBusiness business = (SessionBusiness) AppConfig.getInstance().getAppContext().getBusinessManager(SessionConstants.MODULE);
        business.router();
    }
}
