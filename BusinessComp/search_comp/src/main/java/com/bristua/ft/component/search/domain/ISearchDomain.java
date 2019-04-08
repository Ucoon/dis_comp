package com.bristua.ft.component.search.domain;

import android.support.annotation.NonNull;

import com.bristua.framework.define.IFlutterResult;

/**
 * 获取数据源
 * @author richsjeson
 */
public interface ISearchDomain {
    /**
     * 执行数据源操作
     * @param pResult  向flutter层上层进行回调操作
     */
    void findData(@NonNull IFlutterResult pResult);
}
