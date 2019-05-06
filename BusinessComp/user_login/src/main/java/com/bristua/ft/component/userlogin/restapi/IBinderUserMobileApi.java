package com.bristua.ft.component.userlogin.restapi;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 完成用户信息
 * @author richsjeson
 */
public interface IBinderUserMobileApi {
    /**
     * 用户登录
     * @return
     */
    @POST("mall/api/user/bind/phone/{phone}/{code}/{inviteCode}")
    Observable<String> bindUserMobile(@Path("phone")String phone,@Path("code")String code,@Path("inviteCode") String  inviteCode);
}
