package com.ft.business.component.userinfo.repository;

import com.nd.adhoc.framework.repository.BaseRepository;

/**
 * 信息的仓库，获取仓库中的模型
 * @author richsjeson
 */
public class UserInfoRepository extends BaseRepository {

    private static UserInfoRepository sInstance=null;

    private UserInfoRepository(){

    }

    public static UserInfoRepository getFactory(){

        if(sInstance==null){
            sInstance=new UserInfoRepository();
        }
        return sInstance;
    }

    public void release(){
        mEntitys.clear();
        sInstance=null;
    }
}
