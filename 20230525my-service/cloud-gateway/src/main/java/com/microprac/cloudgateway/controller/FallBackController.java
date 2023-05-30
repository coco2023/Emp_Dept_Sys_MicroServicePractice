package com.microprac.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/orderServiceFallBack")
    public String orderServiceFallBack() {
        return "order Service FallBack is down!";
    }

    @GetMapping("/productServiceFallBack")
    public String productServiceFallBack() {
        return "product Service FallBack is down!";
    }

    @GetMapping("/paymentServiceFallBack")
    public String paymentServiceFallBack() {
        return "payment Service FallBack is down!";
    }

}
