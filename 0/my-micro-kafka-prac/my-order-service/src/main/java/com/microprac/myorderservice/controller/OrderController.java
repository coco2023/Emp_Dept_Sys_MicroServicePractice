package com.microprac.myorderservice.controller;

import com.microprac.myorderservice.dto.Order;
import com.microprac.myorderservice.dto.OrderEvent;
import com.microprac.myorderservice.service.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1")
@RestController
public class OrderController {

    @Autowired
    OrderProducer orderProducer;

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDINGS");
        orderEvent.setMessage("ORDER PENDINGS!");
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);
        return "Order Successfully!";
    }
}
