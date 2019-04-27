package com.ft.business.component.domain;

import android.support.annotation.NonNull;

import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.domain.IDomainFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 评价服务工厂
 *
 * @author richsjeson
 */
public class EvaluateDomainFactory implements IDomainFactory {

    private Map<String,IDomain> mDomains=new HashMap<>();

    private static EvaluateDomainFactory sInstance=null;

    private EvaluateDomainFactory(){

    }


    public static EvaluateDomainFactory getFactory(){

        if(sInstance==null){
            sInstance=new EvaluateDomainFactory();
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
