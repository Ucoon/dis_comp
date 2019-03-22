package com.bristua.tianfen.userlogin.service.factory;

import android.support.annotation.Nullable;

import com.bristua.tianfen.userlogin.domain.model.repository.IUserLoginRepository;
import com.bristua.tianfen.userlogin.domain.model.repository.MobileLoginRepository;
import com.bristua.tianfen.userlogin.service.business.MobileLoginBusiness;
import com.bristua.tianfen.userlogin.service.business.WxLoginBusiness;
import com.bristua.tianfen.userlogin.service.business.defined.IUserLoginBusiness;

/**
 * @author richsjeson
 */
public class UserLoginFactory {

    private static UserLoginFactory sInstance;

    private UserLoginFactory(){}

    public static UserLoginFactory getInstance(){

        if (sInstance == null) {
            synchronized (UserLoginFactory.class) {
                if (sInstance == null) {
                    sInstance = new UserLoginFactory();
                }
            }
        }
        return sInstance;
    }

    public  IUserLoginBusiness getBusiness(@Nullable IUserLoginRepository repository){

        if(repository instanceof MobileLoginRepository){
            return new MobileLoginBusiness();
        }
        return new WxLoginBusiness();
    }

    public void release(){
        sInstance=null;
    }

}
