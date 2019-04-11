package com.bristua.ft.component.userlogin.domain;
import com.bristua.ft.component.userlogin.UserLoginConstant;
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
        UserLoginDomain domain=mDomains.get(pMethod);
        if(mDomains.isEmpty() || domain== null){
            switch (pMethod) {
                case UserLoginConstant.USER_METHOD_MOBILE:
                    domain=new MobileUserDomain();
                    break;
                case UserLoginConstant.USER_METHOD_WX:
                    domain=new WxUserDomain();
                    break;
                case UserLoginConstant.USER_METHOD_SMSCODE:
                    domain=new MobileUserDomain();
                    break;
                default:
                    domain=new MobileUserDomain();
                    break;
            }
            mDomains.put(pMethod,domain);
        }
        return domain;
    }

    public  void release() {
        mDomains.clear();
    }
}
