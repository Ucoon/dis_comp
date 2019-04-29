package com.bristua.ft.comp.rebate.restapi;
import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @author richsjeson
 * 查询返现记录
 */
public interface IQueryFirendConsumeApi {

    /**
     * 获取好友返现记录
     * @param pageNo 页数
     * @param pageSize  一页的条数
     * @return
     */
    @POST("/mall/api/user/query/integral/{pageNo}/{pageSize}")
    // todo zyb 建议后端将post改为get
    Observable<String> queryIntegral(@Path("pageNo") int pageNo,@Path("pageSize") int pageSize);
}
