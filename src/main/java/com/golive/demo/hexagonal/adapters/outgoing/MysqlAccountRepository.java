package com.golive.demo.hexagonal.adapters.outgoing;

import com.golive.demo.hexagonal.adapters.outgoing.repository.db.AccountJPARepository;
import com.golive.demo.hexagonal.adapters.outgoing.repository.db.AccountsEntity;
import com.golive.demo.hexagonal.bankabc.dto.AccountDetails;
import com.golive.demo.hexagonal.bankabc.exception.RepositoryException;
import com.golive.demo.hexagonal.bankabc.ports.outgoing.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MysqlAccountRepository implements AccountRepository {

    @Autowired
    AccountJPARepository accountJPARepository;

    @Override
    public void deleteAccount(String accNo) throws RepositoryException {
        accountJPARepository.deleteByAccNo(accNo);
    }

    @Override
    public long fetchBalance(String accNo) throws RepositoryException {
        Optional<AccountsEntity> accountEntity = accountJPARepository.findByAccNo(accNo);
        return accountEntity.map(AccountsEntity::getBalance).orElse(0L);
    }

    @Override
    public void createAccount(AccountDetails accountDetails) throws RepositoryException {
        AccountsEntity accountsEntity = new AccountsEntity();
        accountsEntity.setAccNo(accountDetails.getAccNo());
        accountsEntity.setAddress(accountDetails.getAddress());
        accountsEntity.setName(accountDetails.getName());
        accountJPARepository.save(accountsEntity);
    }

    @Override
    public AccountDetails fetchAccountDetails(String accNo) throws RepositoryException {
        return null;
    }

    @Override
    public void addBalance(String accNo, long amt) throws RepositoryException {
        accountJPARepository.addBalance(accNo, amt);
    }

    @Override
    public void deductBalance(String accNo, long amt) throws RepositoryException {
        accountJPARepository.deductBalance(accNo, amt);
    }
}
