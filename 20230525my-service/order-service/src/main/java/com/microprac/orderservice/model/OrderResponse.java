package com.microprac.orderservice.model;

import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class OrderResponse {

    private Long orderId;

    private Long productId;

    private Long amount;

    private String orderStatus;

    private Instant orderDate;

    private Long quantity;

}
