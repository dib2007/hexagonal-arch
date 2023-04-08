package golive.demo.hexagonal.bookmymovie.ports.incoming;

import golive.demo.hexagonal.bookmymovie.exceptions.BookingException;
import golive.demo.hexagonal.bookmymovie.dto.BookingDetails;

import java.util.List;

public interface Booking {

    String book(BookingDetails bookingDetails) throws BookingException;
    List<BookingDetails> getBookings(String userId) throws BookingException;
    BookingDetails getBooking(String bookingId) throws BookingException;

}
