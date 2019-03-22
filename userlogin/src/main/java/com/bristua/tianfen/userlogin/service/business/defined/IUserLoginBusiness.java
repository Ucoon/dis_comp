package com.bristua.tianfen.userlogin.service.business.defined;

import android.support.annotation.Nullable;

import com.bristua.tianfen.userlogin.domain.model.repository.IUserLoginRepository;

/**
 * @author richsjeson
 * 用户登录业务
 */
public interface IUserLoginBusiness {
    /**
     * 用户登录
     * @param property
     */
    void userLogin(@Nullable IUserLoginRepository property);
}
