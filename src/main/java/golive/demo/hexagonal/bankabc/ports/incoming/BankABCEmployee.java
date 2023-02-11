package golive.demo.hexagonal.bankabc.ports.incoming;

import golive.demo.hexagonal.bankabc.dto.AccountDetails;
import golive.demo.hexagonal.bankabc.exception.BankOperationException;

public interface BankABCEmployee extends BankABC {

    String createAccount(AccountDetails accountDetails) throws BankOperationException;

    void deleteAccount(String accNo) throws BankOperationException;

}
