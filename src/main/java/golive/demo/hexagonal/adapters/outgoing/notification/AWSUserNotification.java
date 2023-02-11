package golive.demo.hexagonal.adapters.outgoing.notification;

import golive.demo.hexagonal.bankabc.dto.AccountDetails;
import golive.demo.hexagonal.bankabc.dto.TransferDetails;
import golive.demo.hexagonal.bankabc.exception.NotificationException;
import golive.demo.hexagonal.bankabc.ports.outgoing.UserNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AWSUserNotification implements UserNotification {
    @Override
    public void notifyAccountCreation(AccountDetails accountDetails) throws NotificationException {
        log.info("Notifying user about account creation, account details: {}", accountDetails);
    }

    @Override
    public void notifyAccountDeletion(AccountDetails accountDetails) throws NotificationException {
        log.info("Notifying user about account deletion, account details: {}", accountDetails);
    }

    @Override
    public void notifyAmountTransfer(TransferDetails transferDetails) throws NotificationException {
        log.info("Notifying user about amount transfer, transfer details: {}", transferDetails);
    }
}
