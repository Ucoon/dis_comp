package com.bristua.ft.comp.address.wrapper;

/**
 * @author richsjeson
 * 查询地址的入参
 */
public class FindAddressWrapper {

    private int pageNo;

    private  int pageSize;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
