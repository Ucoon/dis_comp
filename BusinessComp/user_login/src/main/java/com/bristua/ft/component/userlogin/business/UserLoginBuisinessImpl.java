package com.bristua.ft.component.userlogin.business;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.alibaba.fastjson.JSONObject;
import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.system.IBusinessManager;
import com.bristua.ft.component.userlogin.R;
import com.bristua.ft.component.userlogin.domain.UserLoginDomain;
import com.bristua.ft.component.userlogin.domain.UserLoginDomainFactory;
import com.bristua.ft.component.userlogin.repository.MobileUserInfo;
import com.bristua.ft.component.userlogin.repository.UserLoginRepository;
import com.bristua.ft.component.userlogin.repository.WxUserInfo;
import com.bristua.ft.component.userlogin.wrapper.MobileUserWrapper;
import com.bristua.ft.component.userlogin.wrapper.WxUserWrapper;
import com.bristua.ft.protocol.Protocol;
import com.bristua.ft.protocol.ProtocolFactory;
import static com.bristua.ft.component.userlogin.UserLoginConstant.USER_METHOD_MOBILE;
import static com.bristua.ft.component.userlogin.UserLoginConstant.USER_METHOD_WX;

/**
 * 设置用户登录模块
 *
 * @author richsjeson
 */
public class UserLoginBuisinessImpl implements IUserLoginBusiness, IBusinessManager {

    private Context mContext;

    public UserLoginBuisinessImpl() {
        mContext = AppConfig.getInstance().getAppContext().getContext();
    }
    @Override
    public void exec(@NonNull String pProtocol, @NonNull IFlutterResult pCallback) {

        if (TextUtils.isEmpty(pProtocol)) {
            return;
        }

        String parserFromProtocol = ProtocolFactory.convertToJson(mContext.getResources().getString(R.string.userlogin_failure_parser), 500, null);
        if (TextUtils.isEmpty(parserFromProtocol)) {
            return;
        }
        Protocol protocol = ProtocolFactory.convertToBean(pProtocol);
        if (protocol == null) {
            //如果协议模块告警信息的初始异常
            pCallback.success(null,500,parserFromProtocol);
            return;
        }
        String method = protocol.getMethod();
        if(TextUtils.isEmpty(method)){
            pCallback.success(null,500,parserFromProtocol);
            return;
        }

        UserLoginRepository userLoginRepository=UserLoginRepository.getFactory();
        userLoginRepository.setUserType(method);
        switch (method) {
            case USER_METHOD_MOBILE:
                gotoMobileLogin(protocol,userLoginRepository,parserFromProtocol,pCallback);
                break;
            case USER_METHOD_WX:
                gotoWxLogin(protocol,userLoginRepository,parserFromProtocol,pCallback);
                break;
            default:
                gotoMobileLogin(protocol,userLoginRepository,parserFromProtocol,pCallback);
                break;
        }
        UserLoginDomain domain= UserLoginDomainFactory.getFactory().getDomain(method);
        if(domain == null){
            pCallback.success(null,500,parserFromProtocol);
            return;
        }
        domain.login(pCallback);
    }

    /**
     * 用户手机登录
     * @param protocol
     * @param pRepository
     */
    private void gotoMobileLogin(@NonNull Protocol protocol,@NonNull UserLoginRepository pRepository,@NonNull String pMessage, @NonNull IFlutterResult pCallback){
        //继续解析出第2个
        MobileUserWrapper userWrapper= JSONObject.parseObject((String) protocol.getData(),MobileUserWrapper.class);

        String phone=userWrapper.getPhone();
        String smsCode=userWrapper.getPhone();

        if(userWrapper == null || TextUtils.isEmpty(phone) || TextUtils.isEmpty(smsCode)){
            pCallback.success(null,500,pMessage);
            return;
        }
        //读取参数信息
       MobileUserInfo userInfo= (MobileUserInfo) pRepository.getUserInfo(USER_METHOD_MOBILE);
       if(userInfo == null){
           pCallback.success(null,500,pMessage);
           return;
       }
       userInfo.setPhoneCode(smsCode);
       userInfo.setMobilePhone(phone);
       //生成对象
    }


    /**
     * 用户手机登录
     * @param protocol
     * @param pRepository
     */
    private void gotoWxLogin(@NonNull Protocol protocol,@NonNull UserLoginRepository pRepository,@NonNull String pMessage, @NonNull IFlutterResult pCallback){
        //继续解析出第2个
        WxUserWrapper userWrapper= JSONObject.parseObject((String) protocol.getData(),WxUserWrapper.class);

        String appid=userWrapper.getAppid();
        String code=userWrapper.getCode();
        String scope=userWrapper.getScope();
        String grantType=userWrapper.getGrantType();

        if(userWrapper == null || TextUtils.isEmpty(appid) || TextUtils.isEmpty(code) || TextUtils.isEmpty(scope)){
            pCallback.success(null,500,pMessage);
            return;
        }
        //读取参数信息
        WxUserInfo userInfo= (WxUserInfo) pRepository.getUserInfo(USER_METHOD_WX);
        if(userInfo == null){
            pCallback.success(null,500,pMessage);
            return;
        }
        userInfo.setAppId(appid);
        userInfo.setCode(code);
        userInfo.setGrantType(grantType);
        userInfo.setScope(scope);
        //生成对象
    }
}
