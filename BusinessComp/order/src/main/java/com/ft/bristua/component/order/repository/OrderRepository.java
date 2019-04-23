package com.ft.bristua.component.order.repository;

import com.nd.adhoc.framework.repository.BaseRepository;

/**
 * @author richsjeson
 * 仓储服务，用于装载实体域
 */
public class OrderRepository extends BaseRepository {

    private static OrderRepository sInstance;

    public static OrderRepository getInstance(){

        if(sInstance == null){

            sInstance=new OrderRepository();
        }
        return sInstance;
    }


    private OrderRepository(){

    }

    public void release(){
        mEntitys.clear();
        sInstance=null;
    }
}
