package com.microprac.paymentservice.entity;

import com.microprac.paymentservice.model.PaymentMode;
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

    private PaymentMode paymentMode;

    private String referenceNumber;

    private Instant paymentDate;

    private String paymentStatus;

    @Column(name = "payment_amount)")
    private Long amount;

}
