package com.bristua.ft.component.search;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.define.IComponent;
import com.bristua.framework.define.IFlutterResult;
import com.bristua.framework.define.annotation.Router;
import com.bristua.framework.define.router.IRouteMeta;
import com.bristua.framework.logger.Logger;
import com.bristua.ft.component.search.business.ISearchBusiness;
import com.bristua.ft.component.search.business.SearchBuisinessImpl;
import com.nd.sdp.android.serviceloader.annotation.Service;

import static android.content.ContentValues.TAG;

@Service(IComponent.class)
@Router(SearchConstant.COMP_MODULE_SEARCH)
public class SearchComp implements IComponent {
    @Override
    public void init() {
        AppConfig.getInstance().getAppContext().registerBusinessManager(SearchConstant.COMP_MODULE_SEARCH,new SearchBuisinessImpl());
    }

    @Override
    public void load() {

    }

    @Override
    public void unload() {

    }

    @Override
    public void destory() {

    }

    @Override
    public void dispatch(@Nullable Object pEvent) {

    }

    @Override
    public void param(@Nullable IRouteMeta pMeta) {

        Logger.LOGD(TAG,"param","");
        IFlutterResult mResult = pMeta.getResult();
        if (mResult == null) {
            return;
        }
        //获取参数
        String params = pMeta.getProtocol();
        if (TextUtils.isEmpty(params)) {
            return;
        }
        ISearchBusiness business= (ISearchBusiness) AppConfig.getInstance().getAppContext().getBusinessManager(SearchConstant.COMP_MODULE_SEARCH);
        business.exec(params,mResult);
    }
}
