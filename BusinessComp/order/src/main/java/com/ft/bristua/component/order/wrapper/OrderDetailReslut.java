package com.ft.bristua.component.order.wrapper;

import java.util.List;

public class OrderDetailReslut {
    String orderId;
    int status; //状态 1:待付款，2:待发货，3:待收货，4:待评价，5：完成，6：已取消
    Address receiveGoods; //收货地址
    String express; //最新一条物流信息

    List<Goods> goods; //商品信息
    String orderNumber; //订单编号
    String createTime; //下单时间

    String payType; //支付方式
    String orderPrice; //订单金额
    String freight; //运费
    String payFee;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Address getReceiveGoods() {
        return receiveGoods;
    }

    public void setReceiveGoods(Address receiveGoods) {
        this.receiveGoods = receiveGoods;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getFreight() {
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight;
    }

    public String getPayFee() {
        return payFee;
    }

    public void setPayFee(String payFee) {
        this.payFee = payFee;
    }

   static class Address{
        String receiveGoodsName;
        String receivePhone;
        String userAddressId;
        String receiveAddressName;
        int status;

       public String getReceiveGoodsName() {
           return receiveGoodsName;
       }

       public void setReceiveGoodsName(String receiveGoodsName) {
           this.receiveGoodsName = receiveGoodsName;
       }

       public String getReceivePhone() {
           return receivePhone;
       }

       public void setReceivePhone(String receivePhone) {
           this.receivePhone = receivePhone;
       }

       public String getUserAddressId() {
           return userAddressId;
       }

       public void setUserAddressId(String userAddressId) {
           this.userAddressId = userAddressId;
       }

       public String getReceiveAddressName() {
           return receiveAddressName;
       }

       public void setReceiveAddressName(String receiveAddressName) {
           this.receiveAddressName = receiveAddressName;
       }

       public int getStatus() {
           return status;
       }

       public void setStatus(int status) {
           this.status = status;
       }
   }

    class Goods {

        String goodsName;
        String goodsPrice;
        String buyNum;
        String allGoodsPrice;
        String goodsImgUrl;
        String goodsId;
        String specMsg;

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getGoodsPrice() {
            return goodsPrice;
        }

        public void setGoodsPrice(String goodsPrice) {
            this.goodsPrice = goodsPrice;
        }

        public String getBuyNum() {
            return buyNum;
        }

        public void setBuyNum(String buyNum) {
            this.buyNum = buyNum;
        }

        public String getAllGoodsPrice() {
            return allGoodsPrice;
        }

        public void setAllGoodsPrice(String allGoodsPrice) {
            this.allGoodsPrice = allGoodsPrice;
        }

        public String getGoodsImgUrl() {
            return goodsImgUrl;
        }

        public void setGoodsImgUrl(String goodsImgUrl) {
            this.goodsImgUrl = goodsImgUrl;
        }

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public String getSpecMsg() {
            return specMsg;
        }

        public void setSpecMsg(String specMsg) {
            this.specMsg = specMsg;
        }
    }
}
