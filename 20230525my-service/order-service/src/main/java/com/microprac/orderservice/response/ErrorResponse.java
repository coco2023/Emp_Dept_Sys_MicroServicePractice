package com.microprac.orderservice.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class ErrorResponse {

    private String errorMessage;

    private String errorCode;
}
