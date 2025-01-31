package com.piseth.bank.account.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppException{

    @ExceptionHandler(APIException.class)
    public ResponseEntity<ResponseException> runtimeExceptionImpl(APIException apiException){
        return ResponseEntity
                .status(apiException.httpStatus.value())
                .body(
                    new ResponseException(
                            apiException.errorDetial.getErrorCode(),
                            apiException.errorDetial.getMessage(),
                            apiException.httpStatus.value(),
                            apiException.message
                    )
                );
    }
}
