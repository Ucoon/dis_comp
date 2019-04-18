package com.bristua.ft.component.userlogin.event;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.component.userlogin.R;
import com.bristua.ft.protocol.ProtocolFactory;

/**
 * @author richsjeson
 */
public class MobileEvent {

    private String mPhone;

    private String mInviteCode;

    private String mPhoneCode;

    private IFlutterResult mResult;

    private static MobileEvent mInstance;

    private Context mContext;

    private final int MOBILEPHONE_MAX_LENGTH = 11;

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

    /**
     * 邀请码输入事件检测
     *
     * @param pInviteCode 邀请码
     */
    public void inputInviteCodeEvent(@NonNull String pInviteCode) {

        this.mInviteCode = pInviteCode;

    }

    /**
     * 手机号码检测
     *
     * @param pMobilePhone 手机号码
     */
    public void inputPhoneEvnet(@NonNull String pMobilePhone) {
        Context context=AppConfig.getInstance().getAppContext().getContext();
        //如果手机号为空
        if (TextUtils.isEmpty(pMobilePhone)) {
            String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.input_mobile_error_blank), 500, null);
            mResult.success(errorTip, 500,null);
            return;
        }

        //校验手机号码
        if (pMobilePhone.length() > MOBILEPHONE_MAX_LENGTH || pMobilePhone.length() < MOBILEPHONE_MAX_LENGTH) {
            String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.input_mobile_error_length), 500, null);
            mResult.success(errorTip, 500,null);
            return;
        }
        //正则表达式验证手机位数
        if(!isMobilePhone(pMobilePhone)){
            //手机号码不合法
            String errorTip = ProtocolFactory.convertToJson(context.getResources().getString(R.string.input_mobile_error_illegal), 500, null);
            mResult.success(errorTip, 500,null);
            return;
        }
        this.mPhone = pMobilePhone;
    }

    /**
     * 手机验证码检测
     *
     * @param pPhoneCode 手机号码
     */
    public void inputPhoneCodeEvent(@NonNull String pPhoneCode) {

        this.mPhoneCode = pPhoneCode;
        //todo richsjeson 此处需要获取手机验证码的短信接口后，才可以获取到,别忘了
        //短信验证码倒计时

    }

    /**
     * 获取邀请码
     *
     * @return 返回邀请码
     */
    public String getInviteCode() {
        return mInviteCode;
    }

    /**
     * 获取手机号码
     *
     * @return 返回手机号码
     */
    public String getPhone() {
        return mPhone;
    }

    /**
     * 获取验证码
     *
     * @return 返回手机验证码
     */
    public String getPhoneCode() {
        return mPhoneCode;
    }

    public void release() {
        mInstance = null;
        mResult = null;
    }

    /**
     * 校验手机号是否合法
     * @param mobileNums
     * @return
     */
    private boolean isMobilePhone(@NonNull String mobileNums) {
        String telRegex = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";
        if (TextUtils.isEmpty(mobileNums)) {
            return false;
        }
        return mobileNums.matches(telRegex);
    }
}
