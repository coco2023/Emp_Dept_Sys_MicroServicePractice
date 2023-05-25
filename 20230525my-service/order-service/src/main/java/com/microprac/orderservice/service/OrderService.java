package com.microprac.orderservice.service;

import com.microprac.orderservice.entity.Order;
import com.microprac.orderservice.model.OrderRequest;
import com.microprac.orderservice.model.OrderResponse;

public interface OrderService {

 public OrderResponse placeOrder(OrderRequest orderRequest);
 public OrderResponse getOrderById(Long orderId);
}
