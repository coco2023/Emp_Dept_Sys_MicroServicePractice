package com.microprac.orderservice.model;

import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class OrderRequest {

    private Long orderId;

    private Long productId;

    private Long quantity;

    private Long amount;

    private String orderStatus;

    private Instant orderDate;

    private PaymentMode paymentMode;
}
