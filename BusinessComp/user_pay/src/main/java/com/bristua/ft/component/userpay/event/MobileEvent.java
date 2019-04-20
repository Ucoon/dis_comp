package com.bristua.ft.component.userpay.event;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IFlutterResult;

/**
 * @author richsjeson
 */
public class MobileEvent {


    private IFlutterResult mResult;

    private static MobileEvent mInstance;

    private Context mContext;


    private MobileEvent() {

    }

    private MobileEvent(@NonNull IFlutterResult pResult) {

        this.mResult = pResult;
        mContext = AppConfig.getInstance().getAppContext().getContext();
    }

    public static MobileEvent newInstance(@NonNull IFlutterResult pResult) {
        if (null == mInstance) {

            mInstance = new MobileEvent(pResult);
        }
        return mInstance;
    }

    public static MobileEvent getInstance() {
        return mInstance;
    }


    public void release() {
        mInstance = null;
        mResult = null;
    }
}
