package com.bristua.ft.component.search.business;

import android.support.annotation.NonNull;

import com.bristua.framework.define.IFlutterResult;
import com.bristua.ft.component.search.repository.SearchRepository;

/**
 * 用户登录业务
 * @author richsjeson
 */
public interface ISearchBusiness {
    /**
     * 模组执行操作
     * @param pProtocol
     * @param pCallback
     */
    void exec(@NonNull String pProtocol, @NonNull IFlutterResult pCallback);

    /**
     * 获取历史列表信息
     * @param pRepository
     * @param pCallback
     */
    void findHistoryFromKey(@NonNull SearchRepository pRepository,@NonNull IFlutterResult pCallback);

    /**
     * 根据关键字进行搜索
     * @param pRepository
     * @param pCallback
     */
    void findProductsFromName(@NonNull SearchRepository pRepository,@NonNull IFlutterResult pCallback);
}
