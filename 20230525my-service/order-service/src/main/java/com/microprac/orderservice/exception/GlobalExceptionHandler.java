package com.microprac.orderservice.exception;

//import com.microprac.orderservice.model.ErrorResponse;
import com.microprac.orderservice.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(OrderServiceException.class)
//    public ResponseEntity<ErrorResponse> handelOrderServiceException(OrderServiceException exception) {
//        ErrorResponse errorResponse = ErrorResponse.builder()
//                .errorMessage(exception.getMessage())
//                .errorCode(exception.getStatusCode())
//                .build();
//
//        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handelOrderServiceException(CustomException exception) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorMessage(exception.getMessage())
                .errorCode(exception.getErrorCode())
                .build();

        return new ResponseEntity<>(
                errorResponse,
                HttpStatus.valueOf(exception.getStatus())
        );
    }

}
