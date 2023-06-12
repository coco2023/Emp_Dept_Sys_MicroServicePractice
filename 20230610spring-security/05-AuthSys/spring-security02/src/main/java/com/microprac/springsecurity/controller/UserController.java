package com.microprac.springsecurity.controller;

import com.microprac.springsecurity.bean.WebResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Log4j2

public class UserController {

//    @GetMapping("/user")
//    public String user(@AuthenticationPrincipal Principal principal, Model model){
//
//        log.info("principal: " + principal);
//        log.info("model: " + model);
//
//        model.addAttribute("username", principal.getName());
//
//        return "user/user";
//    }

    @GetMapping("/user")
    public WebResponse user(@AuthenticationPrincipal Principal principal){
        WebResponse response = WebResponse.success(principal.getName());
        log.info("login Success! response" + response + " Message: " + response.getMessage());
        return response;
    }

    @GetMapping("/admin")
    public WebResponse admin(@AuthenticationPrincipal Principal principal){
        return WebResponse.success(principal.getName());
    }


}
