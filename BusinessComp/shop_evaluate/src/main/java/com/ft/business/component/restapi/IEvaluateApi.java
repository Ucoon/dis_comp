package com.ft.business.component.restapi;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 评价模组 rest api
 *
 * @author RushKing
 */
public interface IEvaluateApi {
    /**
     * 商品评价
     *
     * @return
     */
    @POST("/mall/api/order/goods/evaluate")
    @Headers("Content-Type:application/json")
    Observable<String> goodsEvaluate(@Body RequestBody requestBody);

    /**
     * 获取所有评价
     *
     * @return
     */
    @POST("/mall/api/goods/evaluate")
    @Headers("Content-Type:application/json")
    Observable<String> allEvaluate(@Body RequestBody requestBody);
}
