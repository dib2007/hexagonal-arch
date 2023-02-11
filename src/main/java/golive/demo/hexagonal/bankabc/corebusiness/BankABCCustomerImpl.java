package golive.demo.hexagonal.bankabc.corebusiness;

import golive.demo.hexagonal.bankabc.dto.TransferDetails;
import golive.demo.hexagonal.bankabc.exception.BankOperationException;
import golive.demo.hexagonal.bankabc.exception.NotificationException;
import golive.demo.hexagonal.bankabc.exception.RepositoryException;
import golive.demo.hexagonal.bankabc.ports.incoming.BankABCCustomer;
import golive.demo.hexagonal.bankabc.ports.outgoing.AccountRepository;
import golive.demo.hexagonal.bankabc.ports.outgoing.UserNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BankABCCustomerImpl implements BankABCCustomer {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserNotification userNotification;

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
            TransferDetails transferDetails = TransferDetails.builder()
                    .amount(amt)
                    .sourceAccountNo(sourceAccNo)
                    .destinationAccountNo(destinationAccNo)
                    .build();
            try {
                userNotification.notifyAmountTransfer(transferDetails);
            } catch (NotificationException e) {
                //Handle notification exception
                //May be retry after sometime
            }
        } catch (RepositoryException e) {
            throw new BankOperationException("Transfer failed", e);
        }
    }
}
