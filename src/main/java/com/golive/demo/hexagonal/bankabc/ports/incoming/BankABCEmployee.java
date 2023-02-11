package com.golive.demo.hexagonal.bankabc.ports.incoming;

import com.golive.demo.hexagonal.bankabc.dto.AccountDetails;
import com.golive.demo.hexagonal.bankabc.exception.BankOperationException;

public interface BankABCEmployee extends BankABC {

    String createAccount(AccountDetails accountDetails) throws BankOperationException;

    void deleteAccount(String accNo) throws BankOperationException;

}
