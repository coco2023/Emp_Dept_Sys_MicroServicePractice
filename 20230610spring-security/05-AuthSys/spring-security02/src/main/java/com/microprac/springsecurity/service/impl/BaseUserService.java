package com.microprac.springsecurity.service.impl;

import com.microprac.springsecurity.entity.UserDO;
import com.microprac.springsecurity.repository.UserRepository;
import com.microprac.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary

public class BaseUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void insert(UserDO userDO) {
        String username = userDO.getUsername();
        if (exist(username)) {
            throw new RuntimeException("This User Has already existed!");
        }
        userRepository.save(userDO);
    }

    private boolean exist(String username) {
        // will return 1 if user exists
        UserDO user = userRepository.findByUsername(username);
        return (user != null);
    }

    @Override
    public UserDO getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
