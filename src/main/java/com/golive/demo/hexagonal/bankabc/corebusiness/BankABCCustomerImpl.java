package com.golive.demo.hexagonal.bankabc.corebusiness;

import com.golive.demo.hexagonal.bankabc.exception.BankOperationException;
import com.golive.demo.hexagonal.bankabc.exception.RepositoryException;
import com.golive.demo.hexagonal.bankabc.ports.incoming.BankABCCustomer;
import com.golive.demo.hexagonal.bankabc.ports.outgoing.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BankABCCustomerImpl implements BankABCCustomer {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public long getBalance(String accNo) throws BankOperationException {
        try {
            return accountRepository.fetchBalance(accNo);
        } catch (RepositoryException e) {
            throw new BankOperationException("Fetch balance failed", e);
        }
    }

    @Transactional
    @Override
    public void transfer(String sourceAccNo, String destinationAccNo, long amt) throws BankOperationException {
        try {
            accountRepository.deductBalance(sourceAccNo, amt);
            accountRepository.addBalance(destinationAccNo, amt);
        } catch (RepositoryException e) {
            throw new BankOperationException("Transfer failed", e);
        }
    }
}
