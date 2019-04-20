package com.bristua.ft.component.userpay.restapi;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 微信支付模组 rest api
 *
 * @author RushKing
 */
public interface IWxPayApi {
    /**
     * 微信支付
     *
     * @return
     */
    @POST("/api/wx/app/pay")
    @Headers("Content-Type:application/json")
    Observable<String> wxPay(@Body RequestBody requestBody);
}
