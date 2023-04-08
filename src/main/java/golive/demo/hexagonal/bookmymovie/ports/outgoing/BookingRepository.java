package golive.demo.hexagonal.bookmymovie.ports.outgoing;

import golive.demo.hexagonal.bookmymovie.dto.BookingDetails;

import java.util.List;

public interface BookingRepository {
    String saveBooking(BookingDetails bookingDetails);
    BookingDetails getBookingDetails(String bookingId);
    List<BookingDetails> getBookings(String userId);
}
