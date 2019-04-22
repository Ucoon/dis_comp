package com.bristua.ft.comp.rebate.wrapper;

public class RebateConsumeWrapper {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 总消费额
     */
    private String consumeAmt;
    /**
     * 已返积分个数
     */
    private String iegralNum;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getConsumeAmt() {
        return consumeAmt;
    }

    public void setConsumeAmt(String consumeAmt) {
        this.consumeAmt = consumeAmt;
    }

    public String getIegralNum() {
        return iegralNum;
    }

    public void setIegralNum(String iegralNum) {
        this.iegralNum = iegralNum;
    }
}
