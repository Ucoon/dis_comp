package com.bristua.ft.comp.wallet.restapi;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IUserQueryWallet{

    /**
     * 获取好友返现记录
     * @param pageNo 页数
     * @param pageSize  一页的条数
     * @return
     */
    @FormUrlEncoded
    @POST("/api/user/query/wallet/{pageNo}/{pageSize}")
    // todo zyb 建议后端将post改为get
    Observable<String> qeury(@Path("pageNo") int pageNo, @Path("pageSize") int pageSize);
}
