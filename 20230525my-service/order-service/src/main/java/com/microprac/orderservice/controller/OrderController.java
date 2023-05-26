package com.microprac.orderservice.controller;

import com.microprac.orderservice.entity.Order;
import com.microprac.orderservice.model.OrderRequest;
import com.microprac.orderservice.model.OrderResponse;
import com.microprac.orderservice.service.OrderService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.log4j.Log4j2;


@RequestMapping("/api/v1/orders")
@Log4j2
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/placeOrder")
    // http://localhost:9002/api/v1/orders/placeOrder
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){

        var orderResponse = orderService.placeOrder(orderRequest);
        log.info("Order Id: {}", orderResponse);

        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }


    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable(value = "orderId") Long orderId) {
        OrderResponse orderResponse = orderService.getOrderById(orderId);

        return new ResponseEntity<>(orderResponse, HttpStatus.ACCEPTED);
    }
}
