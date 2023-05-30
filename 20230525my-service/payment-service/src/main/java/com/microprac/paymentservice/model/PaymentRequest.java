package com.microprac.paymentservice.model;

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
