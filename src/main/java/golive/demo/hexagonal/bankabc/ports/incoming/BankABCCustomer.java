package golive.demo.hexagonal.bankabc.ports.incoming;

import golive.demo.hexagonal.bankabc.exception.BankOperationException;

public interface BankABCCustomer extends BankABC {

    void transfer(String sourceAccNo, String destinationAccNo, long amt) throws BankOperationException;

}
