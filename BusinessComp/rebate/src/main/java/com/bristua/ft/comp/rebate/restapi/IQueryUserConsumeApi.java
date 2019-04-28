package com.bristua.ft.comp.rebate.restapi;
import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @author richsjeson
 * 查询返现记录
 */
public interface IQueryUserConsumeApi {

    /**
     * 获取当前用户的消费情况
     * @return
     */
    @POST("/api/query/user/consume")
    // todo zyb 建议后端将post改为get
    Observable<String> queryUserConsume();
}
