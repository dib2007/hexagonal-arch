package golive.demo.hexagonal.bankabc.ports.outgoing;

import golive.demo.hexagonal.bankabc.dto.AccountDetails;
import golive.demo.hexagonal.bankabc.dto.TransferDetails;
import golive.demo.hexagonal.bankabc.exception.NotificationException;

public interface UserNotification {

    void notifyAccountCreation(AccountDetails accountDetails) throws NotificationException;

    void notifyAccountDeletion(AccountDetails accountDetails) throws NotificationException;

    void notifyAmountTransfer(TransferDetails transferDetails) throws NotificationException;
}
