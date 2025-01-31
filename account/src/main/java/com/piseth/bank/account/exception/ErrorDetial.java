package com.piseth.bank.account.exception;


public enum ErrorDetial {

    NOT_FOUND("01", "Data not found"),
    UNCAUGHT_EXCEPTION("05", "Internal server error");

    private String errorCode;
    private String message;

    ErrorDetial(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
