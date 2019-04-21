package com.bristua.ft.comp.address.restapi;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IAddressApi {
    /**
     * 新增用户地址
     * @return
     */
    @POST("mall/api/user/add/address")
    @Headers("Content-Type:application/json")
    Observable<String> add(@Body RequestBody params);

    /**
     * 获取用户地址列表
     * @return
     */
    @POST("mall/api/user/get/address/{pageNo}/{pageSize}")
    @Headers("Content-Type:application/json")
    Observable<String> find(@Path("pageNo") int pageNo,@Path("pageSize") int pageSize);

    /**
     * 修改用户地址
     * @return
     */
    @POST("mall//api/user/update/address")
    @Headers("Content-Type:application/json")
    Observable<String> update(@Body RequestBody params);

}
