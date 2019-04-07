package com.bristua.ft.component.enviroment;
import com.bristua.framework.appconfig.env.define.EnvConstants;
import com.bristua.framework.appconfig.env.define.IEnviroment;
import com.bristua.framework.appconfig.env.define.annomation.Enviroment;
import com.nd.sdp.android.serviceloader.annotation.Service;

/**
 * @author richsjeson
 * 新增开发环境
 */
@Service(IEnviroment.class)
@Enviroment(EnvConstants.ENVIROMENT_PRODUCT)
public class DevelopEnviroment implements  IEnviroment{

    private final String BASE_URL="http://39.104.143.114:9090/mall/";
    @Override
    public String getServiceUrl() {
        return BASE_URL;
    }

    @Override
    public String getPushUrl() {
        return "";
    }
}
