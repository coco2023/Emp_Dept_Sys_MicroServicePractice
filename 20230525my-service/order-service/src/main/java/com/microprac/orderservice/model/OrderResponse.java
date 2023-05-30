package com.microprac.orderservice.model;

import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrderResponse {

    private Long orderId;

    private Long productId;

    private Long amount;

    private String orderStatus;

    private Instant orderDate;

    private Long quantity;

    private PaymentMode paymentMode;

    private ProductDetails productDetails;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ProductDetails{
        private Long productId;
        private String productName;
        private Long price;
        private Long quantity;

    }

}
