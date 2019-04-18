package com.bristua.ft.component.userlogin.business;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IFlutterResult;
import com.nd.adhoc.framework.business.IManager;
import com.nd.adhoc.framework.entity.IEntity;

public class ActivityStartBusiness implements IManager {
    @Override
    public void execute(@NonNull IFlutterResult pResult, @NonNull IEntity pEntity, @NonNull String pData, @NonNull String pMethod, @NonNull Context context) {
        //此处 不要问我为什么就是为了startActivity的
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), "com.bristua.flutter.ftshop.WXAwakenActivity");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
