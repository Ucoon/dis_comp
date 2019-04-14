package com.bristua.ft.component.userlogin.business;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.alibaba.fastjson.JSONObject;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.component.userlogin.R;
import com.bristua.ft.component.userlogin.domain.UserLoginDomainFactory;
import com.bristua.ft.component.userlogin.repository.MobileUserInfo;
import com.bristua.ft.component.userlogin.wrapper.MobileUserWrapper;
import com.bristua.ft.protocol.ProtocolFactory;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.domain.IDomain;
import com.nd.adhoc.framework.entity.IEntity;

/**
 * 手机用户登录
 * @author richsjeson
 */
public class MobileLoginBusiness implements IManager {
    @Override
    public void execute(@NonNull IFlutterResult pResult, @NonNull IEntity pEntity, @NonNull String pData, @NonNull String pMethod, @NonNull Context context) {
        String parserFromProtocol = ProtocolFactory.convertToJson(context.getResources().getString(R.string.userlogin_failure_parser), 500, null);
        MobileUserWrapper userWrapper = JSONObject.parseObject(pData, MobileUserWrapper.class);
        String phone = userWrapper.getPhone();
        String smsCode = userWrapper.getSmsCode();

        if (userWrapper == null || TextUtils.isEmpty(phone) || TextUtils.isEmpty(smsCode)) {
            pResult.success(null, 500, parserFromProtocol);
            return;
        }
        //读取参数信息
        MobileUserInfo userInfo = new MobileUserInfo();
        if (userInfo == null) {
            pResult.success(null, 500, parserFromProtocol);
            return;
        }
        userInfo.setPhoneCode(smsCode);
        userInfo.setMobilePhone(phone);
        IDomain domain = UserLoginDomainFactory.getFactory().getDomain(pMethod);
        if (domain == null) {
            return;
        }
        domain.execute(pEntity, pResult);
    }
}
