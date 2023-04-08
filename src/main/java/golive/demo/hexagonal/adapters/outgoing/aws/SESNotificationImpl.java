package golive.demo.hexagonal.adapters.outgoing.aws;

import golive.demo.hexagonal.bookmymovie.dto.BookingDetails;
import golive.demo.hexagonal.bookmymovie.ports.outgoing.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SESNotificationImpl implements Notification {
    @Override
    public void sendBookingSuccessNotification(BookingDetails bookingDetails) {
        log.info("Sending email to {} with booking Details: {}", bookingDetails.getBookingId(), bookingDetails);
    }
}
