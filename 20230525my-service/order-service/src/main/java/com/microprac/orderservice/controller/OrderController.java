package com.microprac.orderservice.controller;

import com.microprac.orderservice.model.OrderRequest;
import com.microprac.orderservice.model.OrderResponse;
import com.microprac.orderservice.service.OrderService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.log4j.Log4j2;


@RequestMapping("/api/v1/orders")
@Log4j2
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){

        var orderResponse = orderService.placeOrder(orderRequest);
        log.info("Order Id: {}", orderResponse);

        return new ResponseEntity<>(orderResponse, HttpStatus.ACCEPTED);
    }
}
