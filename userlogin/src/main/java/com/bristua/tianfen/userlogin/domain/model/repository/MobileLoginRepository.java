package com.bristua.tianfen.userlogin.domain.model.repository;
import com.bristua.tianfen.userlogin.domain.model.action.MobileAction;

/**
 * 微信登录 --领域
 * @author richsjeson
 */
public class MobileLoginRepository implements IUserLoginRepository {


    public String getPassword() {
        return MobileAction.getInstance().getPassword();
    }


    public String getPhone() {
        return MobileAction.getInstance().getPhone();
    }
}
