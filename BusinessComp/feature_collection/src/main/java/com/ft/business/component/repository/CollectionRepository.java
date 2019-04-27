package com.ft.business.component.repository;

import com.nd.adhoc.framework.repository.BaseRepository;

/**
 * 收藏的仓库，获取仓库中的模型
 * @author richsjeson
 */
public class CollectionRepository extends BaseRepository {

    private static CollectionRepository sInstance=null;

    private CollectionRepository(){

    }

    public static CollectionRepository getFactory(){

        if(sInstance==null){
            sInstance=new CollectionRepository();
        }
        return sInstance;
    }

    public void release(){
        mEntitys.clear();
        sInstance=null;
    }
}
