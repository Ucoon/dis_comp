package com.bristua.ft.comp.address.repository;
import com.nd.adhoc.framework.repository.BaseRepository;

/**
 * 仓储服务
 * @author richsjeson
 */
public class AddressRepository extends BaseRepository {

    private static AddressRepository mInstance;

    public static AddressRepository getInstance(){

        if(mInstance == null){
            mInstance=new AddressRepository();
        }
        return mInstance;
    }

    /**
     * 释放资源
     */
    public void release(){
        mEntitys.clear();
        mInstance=null;
    }
}
