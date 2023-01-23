package com.golive.demo.hexagonal.bankABC.notification;

import com.golive.demo.hexagonal.bankABC.exception.NotificationException;

public interface UserNotification {

    void sendAccCreationEmail(String accNo) throws NotificationException;

    void sendAccDeletionEmail(String accNo) throws NotificationException;

    void sendAccCreationSms(String accNo) throws NotificationException;

    void sendAccDeletionSms(String accNo) throws NotificationException;
}
