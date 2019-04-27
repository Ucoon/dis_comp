package com.ft.business.component.domain;

import android.support.annotation.NonNull;

import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.domain.IDomainFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 收藏服务工厂
 *
 * @author richsjeson
 */
public class CollectionDomainFactory implements IDomainFactory {

    private Map<String, IDomain> mDomains = new HashMap<>();

    private static CollectionDomainFactory sInstance = null;

    private CollectionDomainFactory() {

    }


    public static CollectionDomainFactory getFactory() {

        if (sInstance == null) {
            sInstance = new CollectionDomainFactory();
        }
        return sInstance;
    }

    @Override
    public void putDomain(@NonNull String pMethod, @NonNull IDomain pDomain) {
        mDomains.put(pMethod, pDomain);
    }

    @Override
    public IDomain getDomain(@NonNull String pMethod) {
        return mDomains.get(pMethod);
    }

    public void release() {
        mDomains.clear();
        sInstance = null;
    }
}
