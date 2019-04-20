package com.bristua.ft.interceptor.response.manager;
import android.support.annotation.NonNull;
import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.system.ISharePrefense;

/**
 * token管理器
 * @author richsjeson
 */
public class TokenManager {
    private final static String KEY="token";

    /**
     * 保存token信息
     * @param token
     */
    public static void saveToken(@NonNull String token){
        ISharePrefense sharePrefense=AppConfig.getInstance().getAppContext().getShareprefense();
        sharePrefense.putString(AppConfig.getInstance().getAppContext().getContext(),KEY,token);
    }

    /**
     * 返回token的信息
     * @return
     */
    public static String getToken(){
        ISharePrefense sharePrefense=AppConfig.getInstance().getAppContext().getShareprefense();
        return sharePrefense.getString(AppConfig.getInstance().getAppContext().getContext(),KEY,"");
    }
}
