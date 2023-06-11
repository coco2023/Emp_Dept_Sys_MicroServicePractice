package com.microprac.rbacauthprac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @GetMapping("/form/formLogin")
    public String formLogin() {
        return "formLogin";
    }

    @GetMapping("/form/formHome")
    public String formHome() {
        return "formHome";
    }

    @GetMapping("form/formLoginPost")
    public String formLoginPost() {
        return "formLoginPost";
    }

    @GetMapping("/form/logout")
    public String formLogout() {
        return "formLogout";
    }

    @GetMapping("/basic/basicHome")
    public String basicHome() {
        return "basicHome";
    }

    @GetMapping("/basic/logout")
    public String basicLogout(HttpSession session) {
        session.invalidate();
        return "basicLogout";
    }


}
