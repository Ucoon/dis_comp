package com.ft.bristua.component.order.domain;

import android.support.annotation.NonNull;

import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.domain.IDomainFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author richsjeson
 * 领域工厂类
 */
public class DomainFactory implements IDomainFactory {

    private static DomainFactory sInstance;

    public static DomainFactory getInstance(){

        if(sInstance==null){

            sInstance=new DomainFactory();
        }
        return sInstance;

    }

    private Map<String,IDomain> mDomains=new HashMap<>();
    @Override
    public void putDomain(@NonNull String pMethod, @NonNull IDomain pDomain) {
        mDomains.put(pMethod,pDomain);
    }

    @Override
    public IDomain getDomain(@NonNull String pMethod) {
        return mDomains.get(pMethod);
    }

    public void release(){
        mDomains.clear();
        sInstance=null;
    }
}
