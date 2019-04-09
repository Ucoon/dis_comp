package com.bristua.ft.component.userlogin.business;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.system.AppContext;
import com.bristua.framework.system.IBusinessManager;
import com.bristua.ft.component.userlogin.R;
import com.bristua.ft.component.userlogin.UserLoginConstant;
import com.bristua.ft.component.userlogin.event.MobileEvent;
import com.bristua.ft.component.userlogin.domain.UserLoginDomain;
import com.bristua.ft.component.userlogin.domain.UserLoginDomainFactory;
import com.bristua.ft.component.userlogin.repository.MobileUserInfo;
import com.bristua.ft.component.userlogin.repository.UserLoginRepository;
import com.bristua.ft.protocol.Protocol;
import com.bristua.ft.protocol.ProtocolFactory;

import org.w3c.dom.Text;

import static com.bristua.ft.component.userlogin.UserLoginConstant.USER_LOGIN_MODULE;
import static com.bristua.ft.component.userlogin.UserLoginConstant.USER_METHOD_MOBILE;
import static com.bristua.ft.component.userlogin.UserLoginConstant.USER_METHOD_WX;

/**
 * 设置用户登录模块
 * @author richsjeson
 */
public class UserLoginBuisinessImpl implements IUserLoginBusiness, IBusinessManager {

    private Context mContext;

    public UserLoginBuisinessImpl(){
        mContext= AppConfig.getInstance().getAppContext().getContext();
    }

    public void login(@NonNull String pProtocol, @NonNull  IFlutterResult pCallback) {

//        //创建手机输入事件
//        MobileEvent.newInstance(pCallback);
//        //此处将对Protocl进行解析
//        UserLoginRepository userLoginRepository=UserLoginRepository.getFactory();
//        userLoginRepository.setUserType(getUserType(pProtocol));
//        //1.从json中获取到参数值
//        MobileUserInfo userInfo= (MobileUserInfo) userLoginRepository.getUserInfo(UserLoginConstant.USER_TYPE_MOBILE);
//        userInfo.setMobilePhone(UserLoginConstant.TEST_USER_MOBILEPHONE);
//        userInfo.setInviteCode(UserLoginConstant.TEST_USER_INVITE_CODE);
//        userInfo.setPhoneCode(UserLoginConstant.TEST_USER_MOBILEPHONE_CODE);
//        //执行用户登录模块
//        UserLoginDomain userLoginDoman=UserLoginDomainFactory.getDomain(userLoginRepository.getUserType());
//        userLoginDoman.login(pCallback);
    }

    public void logout(@NonNull IFlutterResult pCallback) {
        //todo zyb 执行怎么个操作，注销需要连接后端进行注销吧
    }


    @Override
    public void exec(@NonNull String pProtocol, @NonNull IFlutterResult pCallback) {

        if(TextUtils.isEmpty(pProtocol)){
            return;
        }
        Protocol protocol= ProtocolFactory.convertToBean(pProtocol);
        if(protocol == null){
            String parserFromProtocol=ProtocolFactory.convertToJson(mContext.getResources().getString(R.string.userlogin_failure_parser),500,null);
            //如果协议模块告警信息的初始异常
            if(TextUtils.isEmpty(parserFromProtocol)){
                return;
            }
        }




//        login();

    }
}
