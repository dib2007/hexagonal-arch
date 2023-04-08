package golive.demo.hexagonal.bookmymovie.core;

import golive.demo.hexagonal.bookmymovie.dto.BookingDetails;
import golive.demo.hexagonal.bookmymovie.exceptions.BookingException;
import golive.demo.hexagonal.bookmymovie.ports.incoming.Booking;
import golive.demo.hexagonal.bookmymovie.ports.outgoing.BookingRepository;
import golive.demo.hexagonal.bookmymovie.ports.outgoing.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingImpl implements Booking {

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    Notification notification;

    @Override
    public String book(BookingDetails bookingDetails) throws BookingException {
        String bookingId = bookingRepository.saveBooking(bookingDetails);
        notification.sendBookingSuccessNotification(bookingDetails);
        return bookingId;
    }

    @Override
    public List<BookingDetails> getBookings(String userId) throws BookingException {
        return bookingRepository.getBookings(userId);
    }

    @Override
    public BookingDetails getBooking(String bookingId) throws BookingException {
        return bookingRepository.getBookingDetails(bookingId);
    }
}
