package com.bristua.ft.component.userlogin.domain;
import android.support.annotation.NonNull;

import com.bristua.ft.component.userlogin.UserLoginConstant;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.domain.IDomainFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户服务工厂
 *
 * @author richsjeson
 */
public class UserLoginDomainFactory implements IDomainFactory {

    private Map<String,IDomain> mDomains=new HashMap<>();

    private static UserLoginDomainFactory sInstance=null;

    private UserLoginDomainFactory(){

    }


    public static UserLoginDomainFactory getFactory(){

        if(sInstance==null){
            sInstance=new UserLoginDomainFactory();
        }
        return sInstance;
    }

    @Override
    public void putDomain(@NonNull String pMethod, @NonNull IDomain pDomain) {
        mDomains.put(pMethod,pDomain);
    }

    @Override
    public IDomain getDomain(@NonNull String pMethod) {
        return mDomains.get(pMethod);
    }

    public  void release() {
        mDomains.clear();
        sInstance=null;
    }
}
