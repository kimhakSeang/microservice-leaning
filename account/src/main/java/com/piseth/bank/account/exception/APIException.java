package com.piseth.bank.account.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class APIException  extends RuntimeException{
    ErrorDetial errorDetial;
    HttpStatus httpStatus;
    String message;
}
