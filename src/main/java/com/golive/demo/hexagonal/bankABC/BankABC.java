package com.golive.demo.hexagonal.bankABC;

import com.golive.demo.hexagonal.bankABC.exception.BankOperationException;

public interface BankABC {

    default long getBalance(String accNo) throws BankOperationException {
        return 0;
    }
}
