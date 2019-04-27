package com.ft.business.component.repository;

import com.nd.adhoc.framework.repository.BaseRepository;

/**
 * 评价的仓库，获取仓库中的模型
 * @author richsjeson
 */
public class EvaluateRepository extends BaseRepository {

    private static EvaluateRepository sInstance=null;

    private EvaluateRepository(){

    }

    public static EvaluateRepository getFactory(){

        if(sInstance==null){
            sInstance=new EvaluateRepository();
        }
        return sInstance;
    }

    public void release(){
        mEntitys.clear();
        sInstance=null;
    }
}
