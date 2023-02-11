package com.golive.demo.hexagonal.bankabc.ports.incoming;

import com.golive.demo.hexagonal.bankabc.exception.BankOperationException;

public interface BankABC {

    default long getBalance(String accNo) throws BankOperationException {
        return 0;
    }
}
