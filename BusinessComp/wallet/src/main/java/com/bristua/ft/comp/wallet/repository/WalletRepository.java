package com.bristua.ft.comp.wallet.repository;

import com.nd.adhoc.framework.repository.BaseRepository;

/**
 * @author richsjeson
 * 仓储服务
 */
public class WalletRepository extends BaseRepository {

    private static WalletRepository sInstance;

    private WalletRepository(){

    }

    public static WalletRepository getInstance(){

        if(sInstance == null){
            sInstance=new WalletRepository();
        }
        return sInstance;
    }



}
