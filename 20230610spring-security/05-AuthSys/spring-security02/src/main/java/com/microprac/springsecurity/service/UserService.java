package com.microprac.springsecurity.service;

import com.microprac.springsecurity.entity.UserDO;

public interface UserService {


    /**
     * create new user
     *
     * username // default Auth: USER
     */
    void insert(UserDO userDO);

    /**
     * get User Info
     * @param username
     * @return UserEntity
     */
    UserDO getByUsername(String username);

}
