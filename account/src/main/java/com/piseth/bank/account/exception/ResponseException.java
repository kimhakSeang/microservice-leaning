package com.piseth.bank.account.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ResponseException{
    String errCode;
    String errMessage;
    int httpCode;
    String description;
}
