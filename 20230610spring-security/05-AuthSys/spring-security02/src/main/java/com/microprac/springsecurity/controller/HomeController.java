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
import org.springframework.web.servlet.ModelAndView;

@RestController
@AllArgsConstructor

public class HomeController {

//    @GetMapping({"/", "/index", "/home"})
//    public ModelAndView root(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("index");
//        return modelAndView;
//    }
//
//    @GetMapping("/login")
//    public ModelAndView login(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login");
//        return modelAndView;
//    }

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public WebResponse register(@RequestBody UserDO userDO) {
        userService.insert(userDO);

        return WebResponse.success("Register Successfully!");
    }


}
