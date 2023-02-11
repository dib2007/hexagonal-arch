package com.golive.demo.hexagonal.bankabc.exception;

public class BankOperationException extends Exception {
    public BankOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
