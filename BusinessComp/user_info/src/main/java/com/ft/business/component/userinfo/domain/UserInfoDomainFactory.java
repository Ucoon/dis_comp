package com.ft.business.component.userinfo.domain;

import android.support.annotation.NonNull;

import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.domain.IDomainFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户服务工厂
 *
 * @author richsjeson
 */
public class UserInfoDomainFactory implements IDomainFactory {

    private Map<String,IDomain> mDomains=new HashMap<>();

    private static UserInfoDomainFactory sInstance=null;

    private UserInfoDomainFactory(){

    }


    public static UserInfoDomainFactory getFactory(){

        if(sInstance==null){
            sInstance=new UserInfoDomainFactory();
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
