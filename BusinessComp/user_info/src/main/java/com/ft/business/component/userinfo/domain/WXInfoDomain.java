package com.ft.business.component.userinfo.domain;

import android.support.annotation.NonNull;

import com.bristua.framework.define.IFlutterResult;
import com.ft.business.component.userinfo.service.WXInfoService;
import com.ft.business.component.userinfo.wrapper.WXInfoWrapper;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 微信信息领域
 *
 * @author richsjeson
 */
public class WXInfoDomain implements IDomain {

    @Override
    public void execute(@NonNull IEntity iEntity, @NonNull IFlutterResult pResult) {
        WXInfoWrapper wxInfoWrapper = (WXInfoWrapper) iEntity.getObjectValue();
        WXInfoService.wxInfo(pResult, wxInfoWrapper);
    }
}
