package com.bristua.tianfen.userlogin.service;

import android.support.annotation.Nullable;

import com.bristua.tianfen.userlogin.domain.model.repository.IUserLoginRepository;
import com.bristua.tianfen.userlogin.service.factory.UserLoginFactory;

/**
 * 用户登录服务
 * @author richsjeson
 */
public class UserLoginService implements IUserLoginService {
    @Override
    public void login(@Nullable IUserLoginRepository property) {

        UserLoginFactory.getInstance().getBusiness(property).userLogin(property);

    }
}
