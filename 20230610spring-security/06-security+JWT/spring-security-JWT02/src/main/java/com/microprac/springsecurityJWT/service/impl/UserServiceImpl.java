package com.microprac.springsecurityJWT.service.impl;

import com.microprac.springsecurityJWT.model.UserDTO;
import com.microprac.springsecurityJWT.repository.UserRepo;
import com.microprac.springsecurityJWT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public Optional<UserDTO> findByUsername(String username) {

        return userRepo.findByName(username);
    }
}
