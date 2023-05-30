package com.microprac.orderservice.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class PaymentRequest {

    private Long orderId;

    private Long amount;

    private String referenceNumber;

    private PaymentMode paymentMode;

}
