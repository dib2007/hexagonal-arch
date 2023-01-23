package com.golive.demo.hexagonal.bankABC.exception;

public class BankOperationException extends Exception {
    public BankOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
