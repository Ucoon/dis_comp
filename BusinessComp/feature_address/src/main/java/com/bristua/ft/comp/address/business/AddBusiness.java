package com.bristua.ft.comp.address.business;
import android.content.Context;
import android.support.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.comp.address.domain.DomainFactory;
import com.bristua.ft.comp.address.entity.Address;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 *
 * 新增地址业务
 * @author richsjeson
 */
public class AddBusiness implements IManager {

    @Override
    public void execute(@NonNull IFlutterResult pResult, @NonNull IEntity pEntity, @NonNull String pData, @NonNull String pMethod, @NonNull Context context) {
        Address address= JSONObject.parseObject(pData,Address.class);
        //此处需要验证address地址的参数是否完整
        if(address == null){
            return;
        }
        //接下来就要将address的数据放入Entity中
        pEntity.setObjectValue(address);
        IDomain domain= DomainFactory.getInstance().getDomain(pMethod);
        if(domain == null){
            return;
        }
        domain.execute(pEntity,pResult);
    }
}
