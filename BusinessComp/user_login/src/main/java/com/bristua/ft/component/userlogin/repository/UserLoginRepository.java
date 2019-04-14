package com.bristua.ft.component.userlogin.repository;

import com.nd.adhoc.framework.repository.BaseRepository;

/**
 * 用户的仓库，获取仓库中的模型
 * @author richsjeson
 */
public class UserLoginRepository extends BaseRepository {

    private static UserLoginRepository sInstance=null;

    private UserLoginRepository(){

    }

    public static UserLoginRepository getFactory(){

        if(sInstance==null){
            sInstance=new UserLoginRepository();
        }
        return sInstance;
    }

    public void release(){
        mEntitys.clear();
        sInstance=null;
    }
}
