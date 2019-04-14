package com.bristua.ft.comp.rebate.repository;

import com.nd.adhoc.framework.repository.BaseRepository;

/**
 * 返现仓储模块
 * @author richsjeson
 */
public class RebateRepository extends BaseRepository {

    private static RebateRepository sInstance;

    public static RebateRepository getInstance(){

        if(sInstance == null){
            sInstance=new RebateRepository();
        }
        return sInstance;
    }

    /**
     * 释放
     */
    public void release(){
        mEntitys.clear();
        sInstance =null;
    }
}
