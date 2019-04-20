package com.bristua.ft.component.userlogin.restapi;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 用户登录模组 rest api
 * @author richsjeson
 */
public interface IWxLoginApi {
    /**
     * 用户登录
     * @return
     */
    @POST("/mall/wx/app/login/{code}")
    @Headers("Content-Type:application/json")
    Observable<String> wxLogin(@Path("code") String pCode);
}
