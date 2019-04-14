package com.bristua.ft.comp.address.domain;

import android.support.annotation.NonNull;

import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.domain.IDomainFactory;

import java.util.HashMap;

/**
 * @author richsjeson
 * 域工厂
 */
public class DomainFactory implements IDomainFactory {

    private static DomainFactory mInstance;

    private HashMap<String,IDomain> mDomainHashMap=new HashMap<>();

    public static DomainFactory getInstance(){

        if(mInstance == null){
            mInstance=new DomainFactory();
        }
        return mInstance;
    }

    @Override
    public void putDomain(@NonNull String pMethod, @NonNull IDomain pDomain) {
        mDomainHashMap.put(pMethod,pDomain);
    }

    @Override
    public IDomain getDomain(@NonNull String pMethod) {
        return mDomainHashMap.get(pMethod);
    }




    public void relase(){
        mDomainHashMap.clear();
    }
}
