package com.golive.demo.hexagonal.bankABC;

import com.golive.demo.hexagonal.bankABC.dto.AccountDetails;
import com.golive.demo.hexagonal.bankABC.exception.BankOperationException;

public interface BankABCEmployee extends BankABC {

    String createAccount(AccountDetails accountDetails) throws BankOperationException;

    void deleteAccount(String accNo) throws BankOperationException;

}
