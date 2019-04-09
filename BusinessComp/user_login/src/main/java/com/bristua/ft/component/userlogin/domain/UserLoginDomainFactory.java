package com.bristua.ft.component.userlogin.domain;

import com.bristua.ft.component.userlogin.UserLoginConstant;
import com.bristua.ft.component.userlogin.repository.UserLoginRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户服务工厂
 *
 * @author richsjeson
 */
public class UserLoginDomainFactory {

    private Map<String,UserLoginDomain> mDomains=new HashMap<>();

    private static UserLoginDomainFactory mInstance=null;

    private UserLoginDomainFactory(){

    }


    public static UserLoginDomainFactory getFactory(){

        if(mInstance==null){
            mInstance=new UserLoginDomainFactory();
        }
        return mInstance;
    }

    /**
     * 获取用户登录的领域
     * @param
     * @return
     */
    public  UserLoginDomain getDomain(String  pMethod) {
        UserLoginDomain domain;
        if(mDomains.isEmpty() || mDomains.get(pMethod)== null){
            switch (pMethod) {
                case UserLoginConstant.USER_METHOD_MOBILE:
                    domain=new MobileUserDomain();
                    break;
                case UserLoginConstant.USER_METHOD_WX:
                    domain=new WxUserDomain();
                    break;
                default:
                    domain=new MobileUserDomain();
                    break;
            }
            mDomains.put(pMethod,domain);
            return domain;
        }
        return mDomains.get(pMethod);
    }

    public  void release() {
        mDomains.clear();
    }
}
