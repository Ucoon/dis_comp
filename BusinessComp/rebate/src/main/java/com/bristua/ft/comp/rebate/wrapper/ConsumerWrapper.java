package com.bristua.ft.comp.rebate.wrapper;

/**
 * @author richsjeson
 *
 */
public class ConsumerWrapper {
    /**
     * 用户名
     */
    private String userItegral;
    /**
     * 总消费额
     */
    private String totalConsumeAmt;

    /**
     * 已返积分个数
     * @return
     */
    public String getUserItegral() {
        return userItegral;
    }

    public void setUserItegral(String userItegral) {
        this.userItegral = userItegral;
    }

    public String getTotalConsumeAmt() {
        return totalConsumeAmt;
    }

    public void setTotalConsumeAmt(String totalConsumeAmt) {
        this.totalConsumeAmt = totalConsumeAmt;
    }
}
