package com.microprac.orderservice.external.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microprac.orderservice.exception.CustomException;
import com.microprac.orderservice.response.ErrorResponse;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {

        ObjectMapper objectMapper = new ObjectMapper();

        log.info("::{}", response.request().url());
        log.info("::{}", response.headers());

        try {
            ErrorResponse errorResponse = objectMapper.readValue(
                    response.body().asInputStream(),
                    ErrorResponse.class
            );

            return new CustomException(
                    errorResponse.getErrorMessage(),
                    errorResponse.getErrorCode(),
                    response.status()
            );

        } catch (IOException e) {
//            throw new RuntimeException(e);
            throw new CustomException(
                    "Internal Serval Error",
                    "INTERNAL_SERVER_ERROR",
                    500                                             // response.status()
            );
        }
    }
}
