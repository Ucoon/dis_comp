package com.ft.business.component.userinfo.restapi;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 微信信息模组 rest api
 *
 * @author RushKing
 */
public interface IWxInfoApi {
    /**
     * 微信信息
     *
     * @return
     */
    @POST("/mall/api/wx/get/userinfo")
    @Headers("Content-Type:application/json")
    Observable<String> wxInfo();
}
