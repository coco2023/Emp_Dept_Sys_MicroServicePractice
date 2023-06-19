package com.microprac.springsecurityJWT.service;

import com.microprac.springsecurityJWT.model.UserDTO;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserService {
    Optional<UserDTO> findByUsername(String username);
}
