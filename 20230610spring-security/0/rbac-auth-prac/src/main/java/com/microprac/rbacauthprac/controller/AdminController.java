package com.microprac.rbacauthprac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AdminController {

    @GetMapping("/admin/dashboard")
    public String admin() {
        return "admin_dashboard";
    }

}
