package com.ft.bristua.component.order.restapi;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * 订单APi
 */
public interface IOrderApi {
    /**
     * 提交订单
     *
     * @param pBody
     * @return
     */
    @POST("/mall/api/order/submit")
    @Headers("Content-Type:application/json")
    Observable<String> submit(@Body RequestBody pBody);


    /**
     * 取消订单
     *
     * @param orderId
     * @return
     */
    @POST("/mall/api/order/cancel/{orderId}")
    @Headers("Content-Type:application/json")
    Observable<String> cancel(@Path("orderId") String orderId);


    /**
     * 确认收货
     *
     * @param orderId
     * @return
     */
    @POST("/mall/api/order/confirm/receipt/{orderId}")
    @Headers("Content-Type:application/json")
    Observable<String> confirm(@Path("orderId") String orderId);


    /**
     * 评价订单
     *
     * @param pBody
     * @return
     */
    @POST("/mall/api/order/goods/evaluate")
    @Headers("Content-Type:application/json")
    Observable<String> comment(@Body RequestBody pBody);

    /**
     * 订单详情
     *
     * @param orderId
     * @return
     */
    @POST("/mall/api/order/detail/{orderId}")
    @Headers("Content-Type:application/json")
    Observable<String> detail(@Path("orderId") String orderId);
}
