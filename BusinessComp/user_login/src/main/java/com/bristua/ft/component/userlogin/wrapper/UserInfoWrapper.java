package com.bristua.ft.component.userlogin.wrapper;
import android.text.TextUtils;

/**
 * 获取用户信息
 * @author richsjeson
 */
public class UserInfoWrapper {
    /**
     * 金币
     */
    private String balanceAmt;
    /**
     * 总的消费额
     */
    private String totalConsume;
    /**
     * 邀请码
     */
    private String userCode;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 我的会员个数
     */
    private String inviteNum;


    private String parentId;

    private String createTime;

    private String userLevel;

    private String userSex;

    private String userImgUrl;

    private String openId;

    private String nickName;

    private String cityName;

    private String countryName;

    private String provinceName;

    private String imgUrl;


    public String getBalanceAmt() {
        return TextUtils.isEmpty(balanceAmt)?"0".trim():balanceAmt;
    }

    public void setBalanceAmt(String balanceAmt) {
        this.balanceAmt = balanceAmt;
    }

    public String getTotalConsume() {
        return TextUtils.isEmpty(totalConsume)?"0".trim():totalConsume;
    }

    public void setTotalConsume(String totalConsume) {
        this.totalConsume = totalConsume;
    }

    public String getUserCode() {
        return TextUtils.isEmpty(userCode)?"-".trim():userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPhone() {
        return TextUtils.isEmpty(phone)?"-".trim():phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInviteNum() {
        return TextUtils.isEmpty(inviteNum)?"0".trim():inviteNum;
    }

    public void setInviteNum(String inviteNum) {
        this.inviteNum = inviteNum;
    }

    public String getParentId() {
        return TextUtils.isEmpty(parentId)?"-".trim():parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCreateTime() {
        return TextUtils.isEmpty(createTime)?"-".trim():createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserLevel() {
        return TextUtils.isEmpty(userLevel)?"-".trim():userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserSex() {
        return TextUtils.isEmpty(userSex)?"-".trim():userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserImgUrl() {
        return TextUtils.isEmpty(userImgUrl)?"file://".trim():userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    public String getOpenId() {
        return TextUtils.isEmpty(openId)?"-".trim():openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return TextUtils.isEmpty(openId)?"-".trim():nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCityName() {
        return TextUtils.isEmpty(cityName)?"-".trim():cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return TextUtils.isEmpty(countryName)?"-".trim():countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getProvinceName() {
        return TextUtils.isEmpty(provinceName)?"-".trim():provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getImgUrl() {
        return TextUtils.isEmpty(imgUrl)?"-".trim():imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
