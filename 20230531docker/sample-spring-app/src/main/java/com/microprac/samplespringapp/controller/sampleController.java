package com.microprac.samplespringapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sampleController {

    @GetMapping("/home")
    public String home() {
        return "Hello Han!";
    }
}
