package com.microprac.paymentservice.service;

import com.microprac.paymentservice.model.PaymentRequest;

public interface PaymentService {

    long doPayment(PaymentRequest request);
}
