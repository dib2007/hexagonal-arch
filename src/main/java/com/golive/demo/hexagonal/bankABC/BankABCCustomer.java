package com.golive.demo.hexagonal.bankABC;

import com.golive.demo.hexagonal.bankABC.exception.BankOperationException;

public interface BankABCCustomer extends BankABC {

    void transfer(String sourceAccNo, String destinationAccNo, long amt) throws BankOperationException;

}
