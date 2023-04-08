package golive.demo.hexagonal.adapters.incoming.web;

import golive.demo.hexagonal.bookmymovie.dto.BookingDetails;
import golive.demo.hexagonal.bookmymovie.exceptions.BookingException;
import golive.demo.hexagonal.bookmymovie.ports.incoming.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(path = "/bookings")
public class BookingWebResource {

    @Autowired
    private Booking booking;

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> book(@RequestBody BookingDetails bookingDetails, @RequestHeader("user-id") String userId) throws BookingException {
        booking.book(bookingDetails);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(path = "/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookingDetails> getBookingById(@PathVariable(name = "bookingId") String bookingId) throws BookingException {
        return ResponseEntity.ok(booking.getBooking(bookingId));
    }
}
