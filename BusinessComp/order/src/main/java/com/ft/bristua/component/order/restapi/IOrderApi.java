package com.ft.bristua.component.order.restapi;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 订单APi
 */
public interface IOrderApi {
    /**
     * 提交订单
     * @param pBody
     * @return
     */
    @POST
    @Headers("Content-Type:application/json")
    Observable<String> submit(@Body RequestBody pBody);


}
