package com.ft.business.component.restapi;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 收藏模组 rest api
 *
 * @author RushKing
 */
public interface ICollectionApi {
    /**
     * 商品收藏
     *
     * @return
     */
    @POST("/mall/api/user/add/goods/collection/{goodsId}")
    @Headers("Content-Type:application/json")
    Observable<String> goodsCollection(@Path("goodsId") String goodsId);

    /**
     * 获取所有收藏
     *
     * @return
     */
    @POST("/mall/api/user/collection/goods/{pageNo}/{pageSize}")
    @Headers("Content-Type:application/json")
    Observable<String> allCollection(@Path("pageNo") int pageNo, @Path("pageSize") int pageSize);

    /**
     * 获取所有收藏
     *
     * @return
     */
    @POST("/mall/api/cancel/goods/collection/{goodsId}")
    @Headers("Content-Type:application/json")
    Observable<String> cancelCollection(@Path("goodsId") String goodsId);
}
