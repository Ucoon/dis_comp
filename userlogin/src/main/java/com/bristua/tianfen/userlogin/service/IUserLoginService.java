package com.bristua.tianfen.userlogin.service;

import android.support.annotation.Nullable;

import com.bristua.tianfen.userlogin.domain.model.repository.IUserLoginRepository;

/**
 * 用户登录
 * @author richsjeson
 */
public interface IUserLoginService {
    /**
     * 执行用户登录
     * @param property
     */
    void login(@Nullable IUserLoginRepository property);
}
