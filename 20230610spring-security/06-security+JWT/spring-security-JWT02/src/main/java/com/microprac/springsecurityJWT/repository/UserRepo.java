package com.microprac.springsecurityJWT.repository;

import com.microprac.springsecurityJWT.model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("select u from User u where u.userName = :username")
    Optional<UserDTO> findByName(@Param("username") String username);
}
