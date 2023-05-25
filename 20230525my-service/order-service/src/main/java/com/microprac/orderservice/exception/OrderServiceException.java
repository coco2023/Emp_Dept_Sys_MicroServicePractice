package com.microprac.orderservice.exception;

import lombok.Data;

@Data
public class OrderServiceException extends RuntimeException{

    private String statusCode;

    public OrderServiceException(String message, String statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
