package com.bristua.ft.component.userlogin.restapi;
import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 获取短信模组 rest api
 * @author richsjeson
 */
public interface ISmsCodeApi {
    /**
     * 用户登录
     * @return
     */
    @POST("/mall/sms/get/cdoe/{phone}")
    @Headers("Content-Type:application/json")
    Observable<String> getSmsCode(@Path("phone") String phone);
}
