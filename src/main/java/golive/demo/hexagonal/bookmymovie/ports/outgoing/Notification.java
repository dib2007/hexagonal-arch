package golive.demo.hexagonal.bookmymovie.ports.outgoing;

import golive.demo.hexagonal.bookmymovie.dto.BookingDetails;

public interface Notification {
    void sendBookingSuccessNotification(BookingDetails bookingDetails);
}
