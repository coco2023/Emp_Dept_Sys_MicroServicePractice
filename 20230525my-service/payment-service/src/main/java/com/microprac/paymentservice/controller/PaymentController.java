package com.microprac.paymentservice.controller;

import com.microprac.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/payment")
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


}
