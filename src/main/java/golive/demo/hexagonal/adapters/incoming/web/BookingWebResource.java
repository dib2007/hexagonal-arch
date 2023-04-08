package golive.demo.hexagonal.adapters.incoming.web;

import golive.demo.hexagonal.bookmymovie.dto.BookingDetails;
import golive.demo.hexagonal.bookmymovie.exceptions.BookingException;
import golive.demo.hexagonal.bookmymovie.ports.incoming.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/bookings")
public class BookingWebResource {

    @Autowired
    private Booking booking;

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> book(@RequestBody BookingDetails bookingDetails) throws BookingException {
        String bookingId = booking.book(bookingDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingId);
    }

    @GetMapping(path = "/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookingDetails> getBookingById(@PathVariable(name = "bookingId") String bookingId) throws BookingException {
        return ResponseEntity.ok(booking.getBooking(bookingId));
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookingDetails>> getUserBookings(@RequestParam(name = "userId") String userId) throws BookingException {
        return ResponseEntity.ok(booking.getBookings(userId));
    }
}
