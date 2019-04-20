package com.bristua.ft.component.userpay.repository;

import com.nd.adhoc.framework.repository.BaseRepository;

/**
 * 支付的仓库，获取仓库中的模型
 * @author richsjeson
 */
public class UserPayRepository extends BaseRepository {

    private static UserPayRepository sInstance=null;

    private UserPayRepository(){

    }

    public static UserPayRepository getFactory(){

        if(sInstance==null){
            sInstance=new UserPayRepository();
        }
        return sInstance;
    }

    public void release(){
        mEntitys.clear();
        sInstance=null;
    }
}
