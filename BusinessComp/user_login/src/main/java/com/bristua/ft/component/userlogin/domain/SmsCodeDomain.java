package com.bristua.ft.component.userlogin.domain;
import android.support.annotation.NonNull;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.component.userlogin.service.MobileCodeService;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * smsCode层
 */
public class SmsCodeDomain implements IDomain {
    @Override
    public void execute(@NonNull IEntity iEntity, @NonNull IFlutterResult pFlutterResult) {
        MobileCodeService.getValidCode(pFlutterResult);
    }
}
