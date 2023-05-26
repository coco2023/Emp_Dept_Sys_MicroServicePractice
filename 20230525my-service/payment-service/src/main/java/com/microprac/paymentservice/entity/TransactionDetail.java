package com.microprac.paymentservice.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder

public class TransactionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private String PaymentMode;

    private String referenceNumber;

    private Instant paymentDate;

    private String paymentStatus;

    @Column(name = "payment_amount)")
    private Long amount;

}
