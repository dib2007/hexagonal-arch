package com.golive.demo.hexagonal.bankabc.corebusiness;

import com.golive.demo.hexagonal.bankabc.dto.AccountDetails;
import com.golive.demo.hexagonal.bankabc.exception.BankOperationException;
import com.golive.demo.hexagonal.bankabc.exception.RepositoryException;
import com.golive.demo.hexagonal.bankabc.ports.incoming.BankABCEmployee;
import com.golive.demo.hexagonal.bankabc.ports.outgoing.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BankABCEmployeeImpl implements BankABCEmployee {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public String createAccount(AccountDetails accountDetails) throws BankOperationException {
        try {
            String accNo = UUID.randomUUID().toString();
            accountDetails.setAccNo(accNo);
            accountRepository.createAccount(accountDetails);
            return accNo;
        } catch (RepositoryException e) {
            throw new BankOperationException("Create account failed", e);
        }
    }

    @Override
    public void deleteAccount(String accNo) throws BankOperationException {
        try {
            accountRepository.deleteAccount(accNo);
        } catch (RepositoryException e) {
            throw new BankOperationException("Account deletion failed", e);
        }
    }
}
