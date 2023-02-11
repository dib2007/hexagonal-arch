package golive.demo.hexagonal.bankabc.ports.incoming;

import golive.demo.hexagonal.bankabc.exception.BankOperationException;

public interface BankABC {

    default long getBalance(String accNo) throws BankOperationException {
        return 0;
    }
}
