package com.bristua.ft.component.userlogin.domain;
import android.support.annotation.NonNull;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.component.userlogin.service.MobileUserLoginService;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * @author richsjeson
 * 手机用户领域 -- 执行用户登录
 */
public class MobileUserDomain implements IDomain {
    @Override
    public void execute(@NonNull IEntity iEntity, @NonNull IFlutterResult pFlutterResult) {
        MobileUserLoginService.login(pFlutterResult);
    }
}
