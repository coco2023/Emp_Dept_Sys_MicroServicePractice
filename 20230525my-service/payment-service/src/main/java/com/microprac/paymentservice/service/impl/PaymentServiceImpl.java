package com.microprac.paymentservice.service.impl;

import com.microprac.paymentservice.entity.TransactionDetail;
import com.microprac.paymentservice.model.PaymentRequest;
import com.microprac.paymentservice.repository.PaymentRepository;
import com.microprac.paymentservice.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public long doPayment(PaymentRequest request) {
        log.info("Record transaction details: " + request);

        TransactionDetail  transactionDetail = TransactionDetail.builder()
                .orderId(request.getOrderId())
                .paymentMode(request.getPaymentMode())
                .referenceNumber(request.getReferenceNumber())
                .paymentDate(Instant.now())
                .amount(request.getAmount())
                .paymentStatus("SUCCESS")
                .build();

        log.info("Payment success!!!" + transactionDetail);

        paymentRepository.save(transactionDetail);

        return transactionDetail.getId();
    }
}
