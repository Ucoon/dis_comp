package com.bristua.ft.component.search.cache;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.bristua.framework.appconfig.AppConfig;
import com.bristua.framework.system.AppContext;
import com.bristua.framework.system.ISharePrefense;

import java.util.ArrayList;
import java.util.List;

/**
 * 历史搜索缓存
 * @author richsjeson
 */
public class HistoryCache {

    public static HistoryCache mInstance;

    private List<String> mSearchKeys=new ArrayList<>();

    private ISharePrefense mSharePrefense;

    private AppContext mContext;

    private final String SHOP_HOSTORY_KEY="SHOP_HOSTORY_KEY";

    public static HistoryCache getInstance(){

        if(mInstance == null){
            mInstance=new HistoryCache();
        }
        return mInstance;
    }

    /**
     * 初始化
     */
    public void init(){

        mContext=AppConfig.getInstance().getAppContext();
        if(mContext==null){
            return;
        }
        mSharePrefense=mContext.getShareprefense();
        String cacheStore=mSharePrefense.getString(mContext.getContext(),SHOP_HOSTORY_KEY,"");
        if(TextUtils.isEmpty(cacheStore)){
            return;
        }
        //如果是这样的话，那么就采用json格式导出吧
        List<String> keys=JSON.parseObject(cacheStore,List.class);
        if(keys.isEmpty()){
            //获取不到资源对吧
            return;
        }
        keys.clear();
        keys.addAll(mSearchKeys);
    }

    /**
     * 保存关键字的能力
     * @param pKey
     */
    public void putKey(@NonNull String pKey){
        if(mSharePrefense == null){
            return;
        }
        mSearchKeys.add(pKey);
        //keys每次都要保存一次
        String cacheStore=JSON.toJSONString(mSearchKeys);
        mSharePrefense.putString(mContext.getContext(),cacheStore,SHOP_HOSTORY_KEY);
    }

    public void deleteKey(@NonNull String pKey){
        if(mSearchKeys.isEmpty()){
            return;
        }
        mSearchKeys.remove(pKey);
    }

    public List<String> findHistorys(){
        return mSearchKeys;
    }

    /**
     * 释放资源
     */
    public void release(){
        mSearchKeys.clear();
    }
}
