package com.ft.business.component.wrapper;

import java.util.List;

public class AllCollectionResult {

    /**
     * totalCount : 1
     * totalPage : 1
     * pageNo : 1
     * pageSize : 1
     * list : [{"goodsId":"12","goodsName":"Cafe Louisiane Sweet Cajun Blackening Sauce","goodsImgUrl":"http://dzcmbristua.oss-cn-beijing.aliyuncs.com/imgage/9824620190509121858.jpg?Expires=1872764338&OSSAccessKeyId=LTAIwWbCqqWYjhDT&Signature=fJlP5y28OWndovAh7ZZEXvYVv4s%3D"}]
     */

    private int totalCount;
    private int totalPage;
    private int pageNo;
    private int pageSize;
    private List<ListBean> list;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

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

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * goodsId : 12
         * goodsName : Cafe Louisiane Sweet Cajun Blackening Sauce
         * goodsImgUrl : http://dzcmbristua.oss-cn-beijing.aliyuncs.com/imgage/9824620190509121858.jpg?Expires=1872764338&OSSAccessKeyId=LTAIwWbCqqWYjhDT&Signature=fJlP5y28OWndovAh7ZZEXvYVv4s%3D
         */

        private String goodsId;
        private String goodsName;
        private String goodsImgUrl;
        private String goodsPrice;

        public String getGoodsPrice() {
            return goodsPrice;
        }

        public void setGoodsPrice(String goodsPrice) {
            this.goodsPrice = goodsPrice;
        }

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getGoodsImgUrl() {
            return goodsImgUrl;
        }

        public void setGoodsImgUrl(String goodsImgUrl) {
            this.goodsImgUrl = goodsImgUrl;
        }
    }
}
