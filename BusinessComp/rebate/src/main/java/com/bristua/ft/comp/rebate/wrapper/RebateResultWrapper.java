package com.bristua.ft.comp.rebate.wrapper;

import java.util.List;

/**
 * @author richsjeson
 * 用户积分详情统计信息
 */
public class RebateResultWrapper {

    private int totalCount;

    private List<RebateConsumeWrapper> list;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<RebateConsumeWrapper> getList() {
        return list;
    }

    public void setList(List<RebateConsumeWrapper> list) {
        this.list = list;
    }
}
