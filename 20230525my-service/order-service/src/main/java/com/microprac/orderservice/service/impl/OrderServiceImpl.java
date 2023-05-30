package com.microprac.orderservice.service.impl;

import com.microprac.orderservice.entity.Order;
import com.microprac.orderservice.exception.OrderServiceException;
import com.microprac.orderservice.external.client.PaymentService;
import com.microprac.orderservice.external.client.ProductService;
import com.microprac.orderservice.model.OrderRequest;
import com.microprac.orderservice.model.OrderResponse;
import com.microprac.orderservice.model.PaymentMode;
import com.microprac.orderservice.model.PaymentRequest;
import com.microprac.orderservice.repository.OrderRepository;
import com.microprac.orderservice.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        /**
         * 1. order entity -> save the data with the status order created
         */
        Order order = Order.builder()
                .productId(orderRequest.getProductId())
                .amount(orderRequest.getAmount())
//                .orderStatus("CREATED")
//                .orderStatus(orderRequest.getOrderStatus())
//                .orderDate(orderRequest.getOrderDate())
                .orderDate(new Date().toInstant())
                .quantity(orderRequest.getQuantity())
                .paymentMode(orderRequest.getPaymentMode())
                .orderStatus(null)
                .build();

        /**
         * Based on step 3, this part will no longer be used
         */
//        order = orderRepository.save(order);
//        log.info("ordered on: {}", order.getOrderDate());
//
//        OrderResponse orderResponse = new OrderResponse();
//        copyProperties(order, orderResponse);

        /**
         * 2. product service -> block product(reduce the quantity)
         */
        productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());
        log.info("product quantity has been changed!");

        /**
         * 3. payment service -> check the payment service -> payments -> success -> complete, else cancelled
         */
//        log.info("Calling Payment service to complete payment");
//
//        PaymentRequest paymentRequest = PaymentRequest.builder()
//                .orderId(order.getOrderId())
//                .paymentMode(orderRequest.getPaymentMode())
//                .amount(orderRequest.getAmount())
//                .build();
//
//        String orderStatus = null;
//
//        try{
//            paymentService.doPayment(paymentRequest);
//            log.info("Payment DONE SUCCESFULLY!!!!!");
//            orderStatus = "PLACED";
//        } catch (Exception e) {
//            log.error("Error order in the Payment !!!!");
//            orderStatus = "PAYMENT_FAILED";
//        }
//
//        order.setOrderStatus(orderStatus);

        orderRepository.save(order);
        log.info("Order Placed Successfully!!!" + order);
        OrderResponse orderResponse = new OrderResponse();
        copyProperties(order, orderResponse);

        return orderResponse;
    }

    @Override
    public OrderResponse getOrderById(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderServiceException(
                        "orderId - " + orderId + " does not exist! ",
                        "ORDER_NOT_FOUND"
                ));

        log.info("order found!! order.getProductId(): " + order.getProductId());

        String url = "http://PRODUCT-SERVICE/api/v1/products/" + order.getProductId();
        log.info("url: " + url);

        OrderResponse.ProductDetails productDetails =
                restTemplate.getForObject(
                        url,
                        OrderResponse.ProductDetails.class
                );

        System.out.println("productDetails" + productDetails.toString());
        log.info("productDetails!! " + productDetails);

        OrderResponse orderResponse = new OrderResponse();
        copyProperties(order, orderResponse);
        orderResponse.setProductDetails(productDetails);

        return orderResponse;
    }
}
