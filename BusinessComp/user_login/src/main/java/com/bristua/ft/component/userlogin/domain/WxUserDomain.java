package com.bristua.ft.component.userlogin.domain;
import android.support.annotation.NonNull;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.component.userlogin.service.WxUserLoginService;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 微信用户领域
 * @author richsjeson
 */
public class WxUserDomain implements IDomain {

    @Override
    public void execute(@NonNull IEntity iEntity, @NonNull IFlutterResult pResult) {
        String code= (String) iEntity.getObjectValue();
        WxUserLoginService.login(pResult,code);
    }
}
