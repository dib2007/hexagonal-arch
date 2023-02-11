package golive.demo.hexagonal.bankabc.notification;

import golive.demo.hexagonal.bankabc.exception.NotificationException;

public interface UserNotification {

    void sendAccCreationEmail(String accNo) throws NotificationException;

    void sendAccDeletionEmail(String accNo) throws NotificationException;

    void sendAccCreationSms(String accNo) throws NotificationException;

    void sendAccDeletionSms(String accNo) throws NotificationException;
}
