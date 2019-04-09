package com.bristua.ft.protocol;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * 协议工厂
 * @author richsjeson
 */
public class ProtocolFactory {
    /**
     * 转换成实体
     * @param pProtocol 协议报文
     * @return 返回具体的协议体报文
     */
    public static Protocol convertToBean(@NonNull String pProtocol){
        try {

            if (TextUtils.isEmpty(pProtocol)) {
                return null;
            }
            Protocol protocol = JSONObject.parseObject(pProtocol, Protocol.class);
            return protocol;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转换成json格式化
     * @param pMessage 消息体
     * @param pErrorCode 编码
     * @param pData  具体数据
     * @return json串
     */
    public static String convertToJson(@NonNull String pMessage,int pErrorCode,@NonNull Object pData){

        NativeResult result=new NativeResult();
        if(TextUtils.isEmpty(pMessage)){
            pMessage="";
        }
        result.setMessgae(pMessage);
        result.setCode(pErrorCode);
        result.setData(pData);
        String resultData= JSON.toJSONString(result);
        return resultData;
    }
}
