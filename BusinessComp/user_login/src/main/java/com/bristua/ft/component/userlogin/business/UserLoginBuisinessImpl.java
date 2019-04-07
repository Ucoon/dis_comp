package com.bristua.ft.component.userlogin.business;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.system.IBusinessManager;
import com.bristua.ft.component.userlogin.UserLoginConstant;
import com.bristua.ft.component.userlogin.event.MobileEvent;
import com.bristua.ft.component.userlogin.domain.UserLoginDomain;
import com.bristua.ft.component.userlogin.domain.UserLoginDomainFactory;
import com.bristua.ft.component.userlogin.repository.MobileUserInfo;
import com.bristua.ft.component.userlogin.repository.UserLoginRepository;

/**
 * 设置用户登录模块
 * @author richsjeson
 */
public class UserLoginBuisinessImpl implements IUserLoginBusiness, IBusinessManager {

    public void login(@NonNull String pProtocol, @NonNull  IFlutterResult pCallback) {
        if(TextUtils.isEmpty(pProtocol)){
            return;
        }
        //创建手机输入事件
        MobileEvent.newInstance(pCallback);
        //此处将对Protocl进行解析
        UserLoginRepository userLoginRepository=UserLoginRepository.getFactory();
        userLoginRepository.setUserType(getUserType(pProtocol));
        //1.从json中获取到参数值
        MobileUserInfo userInfo= (MobileUserInfo) userLoginRepository.getUserInfo(UserLoginConstant.USER_TYPE_MOBILE);
        userInfo.setMobilePhone(UserLoginConstant.TEST_USER_MOBILEPHONE);
        userInfo.setInviteCode(UserLoginConstant.TEST_USER_INVITE_CODE);
        userInfo.setPhoneCode(UserLoginConstant.TEST_USER_MOBILEPHONE_CODE);
        //执行用户登录模块
        UserLoginDomain userLoginDoman=UserLoginDomainFactory.getDomain(userLoginRepository.getUserType());
        userLoginDoman.login(pCallback);
    }

    public void logout(@NonNull IFlutterResult pCallback) {
        //todo zyb 执行怎么个操作，注销需要连接后端进行注销吧
    }

    /**
     * 获取当前用户的类型
     * @param pProtocol
     * @return
     */
    private int getUserType(@NonNull String pProtocol){
        return UserLoginConstant.USER_TYPE_MOBILE;
    }

    @Override
    public void exec(@NonNull String pProtocol, @NonNull IFlutterResult pCallback) {
        //根据报文执行情况，实现数据操作，Todo richsjeson 暂时没有注销接口，测试阶段先采用用户登录吧！！哈哈哈哈哈哈
        login(pProtocol,pCallback);
    }
}
