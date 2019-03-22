package com.bristua.tianfen.userlogin;
import android.support.annotation.Nullable;
import com.bristua.framework.define.IComponent;
import com.bristua.framework.define.router.IRouteMeta;
import com.bristua.tianfen.userlogin.domain.model.action.MobileAction;
import com.bristua.tianfen.userlogin.service.IUserLoginService;
import com.bristua.tianfen.userlogin.service.UserLoginService;
import com.bristua.tianfen.userlogin.service.factory.UserLoginFactory;
import com.nd.sdp.android.serviceloader.annotation.Service;
/**
 * 用户登录组件
 * @author richsjeson
 */
@Service(IComponent.class)
@com.bristua.framework.define.annomation.Router(2)
public class UserLoginComponent implements IComponent {

    private IUserLoginService mSerivce;

    @Override
    public void init() {
        mSerivce=new UserLoginService();
    }

    @Override
    public void load() {

    }

    @Override
    public void unload() {

    }

    @Override
    public void destory() {
        MobileAction.getInstance().release();
        UserLoginFactory.getInstance().release();
    }

    @Override
    public void dispatch(@Nullable Object pEvent) {

    }

    @Override
    public void param(@Nullable IRouteMeta pMeta) {

        //从组件内部取出数据进行操作
//        mSerivce.login();
    }
}
