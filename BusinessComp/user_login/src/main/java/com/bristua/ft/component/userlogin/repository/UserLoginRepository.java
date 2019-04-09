package com.bristua.ft.component.userlogin.repository;
import android.support.annotation.NonNull;

import com.bristua.ft.component.userlogin.UserLoginConstant;
import com.bristua.ft.component.userlogin.domain.UserLoginDomain;
import com.bristua.ft.component.userlogin.domain.UserLoginDomainFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户的仓库，获取仓库中的模型
 * @author richsjeson
 */
public class UserLoginRepository {

    private static UserLoginRepository mInstance=null;

    private String mUserType;

    private Map<String,IUserInfo> mUserInfos=new HashMap<>();

    private UserLoginRepository(){

    }

    public static UserLoginRepository getFactory(){

        if(mInstance==null){
            mInstance=new UserLoginRepository();
        }
        return mInstance;
    }
    /**
     * 获取用户的实体对象类
     * @param pMethod 获取Method对象
     * @return
     */
    public   IUserInfo getUserInfo(@NonNull String pMethod){

        IUserInfo userInfo;
        if(mUserInfos.isEmpty() || mUserInfos.get(pMethod)==null){
            switch (pMethod) {
                case UserLoginConstant.USER_METHOD_MOBILE:
                    userInfo=new MobileUserInfo();
                    mUserInfos.put(UserLoginConstant.USER_METHOD_MOBILE,new MobileUserInfo());
                    break;
                case UserLoginConstant.USER_METHOD_WX:
                    userInfo=new WxUserInfo();
                    mUserInfos.put(UserLoginConstant.USER_METHOD_WX,new WxUserInfo());
                    break;
                default:
                    userInfo=new MobileUserInfo();
                    break;
            }
            mUserInfos.put(pMethod,userInfo);
            return userInfo;
        }
        return mUserInfos.get(pMethod);
    }

    /**
     * 实例化后应当进行销毁
     */
    public  void release(){
        mUserInfos.clear();
    }

    public String getUserType(){
        return mUserType;
    }

    public void setUserType(@NonNull String  pMethodType){
        this.mUserType=pMethodType;
    }

}
