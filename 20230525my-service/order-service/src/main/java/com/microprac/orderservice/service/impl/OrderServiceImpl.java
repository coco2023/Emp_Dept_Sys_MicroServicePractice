package com.microprac.orderservice.service.impl;

import com.microprac.orderservice.entity.Order;
import com.microprac.orderservice.exception.OrderServiceException;
import com.microprac.orderservice.model.OrderRequest;
import com.microprac.orderservice.model.OrderResponse;
import com.microprac.orderservice.repository.OrderRepository;
import com.microprac.orderservice.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        // order entity -> save the data with the status order created
        Order order = Order.builder()
                .productId(orderRequest.getProductId())
                .amount(orderRequest.getAmount())
                .orderStatus(orderRequest.getOrderStatus())
//                .orderDate(orderRequest.getOrderDate())
                .orderDate(new Date().toInstant())
                .quantity(orderRequest.getQuantity())
                .build();

        order = orderRepository.save(order);
        log.info("ordered on: {}", order.getOrderDate());

        OrderResponse orderResponse = new OrderResponse();
        copyProperties(order, orderResponse);

        // product service -> block product(reduce the quantity)




        // payment service -> check the payment service -> payments -> success -> complete, else cancelled


        return orderResponse;
    }

    @Override
    public OrderResponse getOrderById(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderServiceException(
                        "orderId - " + orderId + " does not exist! ",
                        "ORDER_NOT_FOUND"
                ));

        OrderResponse orderResponse = new OrderResponse();
        copyProperties(order, orderResponse);

        return orderResponse;
    }
}
