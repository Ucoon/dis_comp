package com.bristua.ft.comp.wallet.domain;
import android.support.annotation.NonNull;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.domain.IDomainFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * 业务工厂领域
 * @author richsjeson
 */
public class WalletDomainFactory implements IDomainFactory {

    private Map<String,IDomain> domainMap=new HashMap<>();

    private static WalletDomainFactory sInstance;

    /**
     * 获取实例化
     * @return
     */
    public static WalletDomainFactory getInstance(){

        if(sInstance==null){
            sInstance=new WalletDomainFactory();
        }
        return sInstance;
    }

    @Override
    public void putDomain(@NonNull String pMethod, @NonNull IDomain pDomain) {
        domainMap.put(pMethod,pDomain);
    }

    @Override
    public IDomain getDomain(@NonNull String pMethod) {
        return domainMap.get(pMethod);
    }

    /**
     * 资源释放
     */
    public void release(){
        domainMap.clear();
        sInstance=null;
    }
}
