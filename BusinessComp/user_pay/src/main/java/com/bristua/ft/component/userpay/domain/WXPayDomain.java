package com.bristua.ft.component.userpay.domain;

import android.support.annotation.NonNull;

import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.component.userpay.service.WXPayService;
import com.bristua.ft.component.userpay.wrapper.WXPayWrapper;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 微信支付领域
 *
 * @author richsjeson
 */
public class WXPayDomain implements IDomain {

    @Override
    public void execute(@NonNull IEntity iEntity, @NonNull IFlutterResult pResult) {
        WXPayWrapper wxPayWrapper = (WXPayWrapper) iEntity.getObjectValue();
        WXPayService.wxPay(pResult, wxPayWrapper);
    }
}
