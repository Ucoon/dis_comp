package com.bristua.ft.comp.rebate.domain;

import android.support.annotation.NonNull;

import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.domain.IDomainFactory;

import java.util.HashMap;
import java.util.Map;

public class DomainFactory implements IDomainFactory {

    private Map<String,IDomain> mDomians=new HashMap<>();

    private static DomainFactory sInstance;


    private DomainFactory(){

    }

    public static DomainFactory getInstance(){

        if(sInstance== null){
            sInstance=new DomainFactory();
        }
        return sInstance;
    }


    @Override
    public void putDomain(@NonNull String pMethod, @NonNull IDomain pDomain) {

        mDomians.put(pMethod,pDomain);
    }

    @Override
    public IDomain getDomain(@NonNull String pMethod) {
        return mDomians.get(pMethod);
    }


    public void release() {
        mDomians.clear();
        sInstance=null;
    }
}
