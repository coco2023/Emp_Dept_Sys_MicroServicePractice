package com.microprac.springsecurity.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@Log4j2

public class UserController {

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal Principal principal, Model model){

        log.info("principal: " + principal);
        log.info("model: " + model);

        model.addAttribute("username", principal.getName());

        return "user/user";
    }

}
