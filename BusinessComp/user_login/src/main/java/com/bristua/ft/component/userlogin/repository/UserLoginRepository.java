package com.bristua.ft.component.userlogin.repository;
import com.bristua.ft.component.userlogin.UserLoginConstant;
import com.bristua.ft.component.userlogin.domain.UserLoginDomain;
import com.bristua.ft.component.userlogin.domain.UserLoginDomainFactory;

/**
 * 用户的仓库，获取仓库中的模型
 * @author richsjeson
 */
public class UserLoginRepository {

    private static UserLoginRepository mInstance=null;

    private int mUserType;

    private IUserInfo mUserInfo;

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
     * @param mUserType
     * @return
     */
    public   IUserInfo getUserInfo(int mUserType){
        switch (mUserType) {
            case UserLoginConstant.USER_TYPE_MOBILE:
                mUserInfo= new MobileUserInfo();
                break;
            case UserLoginConstant.USER_TYPE_WX:
                mUserInfo= new WxUserInfo();
                break;
            default:
                mUserInfo= new WxUserInfo();
                break;
        }
        return mUserInfo;
    }

    /**
     * 实例化后应当进行销毁
     */
    public static void release(){
        mInstance=null;
    }

    public  IUserInfo getUserInfo(){
        return mUserInfo;
    }

    public int getUserType(){
        return mUserType;
    }

    public void setUserType(int pUserType){
        this.mUserType=pUserType;
    }

}
