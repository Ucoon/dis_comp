package com.bristua.ft.component.userlogin.restapi;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 获取用户信息
 * @author richsjeson
 */
public interface IGetUserInfoApi {
    /**
     * 获取用户信息
     * @return
     */
    @POST("mall/api/wx/get/userinfo")
    @Headers("Content-Type:application/json")
    Observable<String> getUserInfo();
}
