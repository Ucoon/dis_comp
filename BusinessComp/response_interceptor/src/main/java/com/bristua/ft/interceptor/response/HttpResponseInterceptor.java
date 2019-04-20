package com.bristua.ft.interceptor.response;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bristua.framework.logger.Logger;
import com.bristua.ft.interceptor.response.exception.BristuaApiException;
import com.bristua.ft.interceptor.response.manager.TokenManager;
import com.bristua.ft.interceptor.response.wrapper.AccessTokenData;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 拦截返回值，进行统一的异常捕捉
 */
public class HttpResponseInterceptor implements Interceptor {

    private String TAG = HttpResponseInterceptor.class.getName();

    private final String TOKEN = "token";

    private final int INTERCEPT_SUCCESS = 0;

    @Override
    public Response intercept(Chain chain) throws IOException {
        String token= TokenManager.getToken();
        Request request = chain.request();

        if(!TextUtils.isEmpty(token)){
            request=request.newBuilder()
                    .addHeader(TOKEN,token)
                    .addHeader("Content-Type", "application/json")
                    .build();
        }

        Response response = chain.proceed(request);

        //拦截到了response
        if (response.code() != HttpStatus.STATUS_CODE_SUCCESS) {
            return response;
        }
        //解析数据完，制造数据
        String result = response.body().string();
        if (TextUtils.isEmpty(result)) {
            //不执行重新构造response
            return response;
        }
        HttpResult httpResult = JSONObject.parseObject(result, HttpResult.class);
        //检测当前是否符合200
        if (httpResult.getCode() != INTERCEPT_SUCCESS) {
            //此处需要进行统一异常拦截
            throw new BristuaApiException(httpResult.getMsg(), httpResult.getCode());
        }

        if (httpResult.getData() == null) {
            //获取到拦截失败后的对象描述
            //此处需要进行统一异常拦截
            throw new BristuaApiException("this data is not exists", HttpStatus.STATUS_EXEC_ERROR);
        }
        //拦截带token的数据包体，取出token后，放入header中

        String data = JSON.toJSONString(httpResult.getData());
        AccessTokenData accessTokenData = JSONObject.parseObject(data, AccessTokenData.class);

        if (!TextUtils.isEmpty(accessTokenData.getToken())) {
            TokenManager.saveToken(accessTokenData.getToken());
            return response;
        }

        //制造数据报文只返回data数据源
        String resultData = (String) httpResult.getData();
        response = new Response.Builder()
                .code(HttpStatus.STATUS_CODE_SUCCESS)
                .addHeader("Content-Type", "application/json")
                .body(ResponseBody.create(MediaType.parse("application/json"), resultData))
                .build();
        return response;
    }
}
