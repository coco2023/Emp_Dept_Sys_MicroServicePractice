package com.microprac.springsecurity.controller;

import com.microprac.springsecurity.bean.WebResponse;
import com.microprac.springsecurity.entity.UserDO;
import com.microprac.springsecurity.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor

public class HomeController {

//    @GetMapping({"/", "/index", "/home"})
//    public String root(){
//        return "index";
//    }
//
//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public WebResponse register(@RequestBody UserDO userDO) {
        userService.insert(userDO);

        return WebResponse.success("Register Successfully!");
    }


}
