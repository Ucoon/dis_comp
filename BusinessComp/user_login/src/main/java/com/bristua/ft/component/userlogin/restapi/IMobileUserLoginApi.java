package com.bristua.ft.component.userlogin.restapi;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 用户登录模组 rest api
 * @author richsjeson
 */
public interface IMobileUserLoginApi {
    /**
     * 用户登录
     * @return
     */
    @POST("mall/api/user/login")
    @Headers("Content-Type:application/json")
    Observable<String> userLogin(@Body RequestBody params);
}
