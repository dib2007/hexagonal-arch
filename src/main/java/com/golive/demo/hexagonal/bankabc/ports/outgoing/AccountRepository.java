package com.golive.demo.hexagonal.bankabc.ports.outgoing;

import com.golive.demo.hexagonal.bankabc.dto.AccountDetails;
import com.golive.demo.hexagonal.bankabc.exception.RepositoryException;

public interface AccountRepository {

    void deleteAccount(String accNo) throws RepositoryException;

    long fetchBalance(String accNo) throws RepositoryException;

    void createAccount(AccountDetails accountDetails) throws RepositoryException;

    AccountDetails fetchAccountDetails(String accNo) throws RepositoryException;

    void addBalance(String accNo, long amt) throws RepositoryException;

    void deductBalance(String accNo, long amt) throws RepositoryException;
}
