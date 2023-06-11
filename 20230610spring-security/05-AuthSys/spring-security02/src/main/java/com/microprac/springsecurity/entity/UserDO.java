package com.microprac.springsecurity.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data

public class UserDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * user Account name
     */
    private String username;

    /**
     * password
     */
    private String password;

    /**
     * user Role
     */
    private String role;


    /**
     * user nick Name
     */
    private String nickname;


}
