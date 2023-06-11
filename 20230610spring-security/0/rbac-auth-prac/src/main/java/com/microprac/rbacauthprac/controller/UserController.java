package com.microprac.rbacauthprac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

    @GetMapping("/user/dashboard")
    public String user() {
        return "user_dashboard";
    }

}
