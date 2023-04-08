package golive.demo.hexagonal.adapters.outgoing.mongo;

import golive.demo.hexagonal.bookmymovie.dto.BookingDetails;
import golive.demo.hexagonal.bookmymovie.dto.Slot;
import golive.demo.hexagonal.bookmymovie.ports.outgoing.BookingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class BookingRepositoryImpl implements BookingRepository {

    @Autowired
    BookingMongoRepository bookingMongoRepository;
    @Autowired
    MovieMongoRepository movieMongoRepository;

    @Override
    public void saveBooking(BookingDetails bookingDetails) {
        Optional<MovieDocument> movieDocument = movieMongoRepository.findById(bookingDetails.getMovieId());
        if (movieDocument.isPresent()) {
            BookingDocument bookingDocument = new BookingDocument();
            bookingDocument.setMovieId(bookingDetails.getMovieId());
            bookingDocument.setMovieName(movieDocument.get().getMovieName());
            bookingDocument.setUserId(bookingDetails.getUserId());
            bookingDocument.setSeats(bookingDetails.getSeats());
            bookingDocument.setStartTime(bookingDetails.getSlot().getStartTime());
            bookingDocument.setEndTime(bookingDetails.getSlot().getEndTime());
            bookingDocument.setSeats(bookingDetails.getSeats());
            bookingMongoRepository.save(bookingDocument);
        } else {
            log.info("Could not fetch a movie with movie ID: {}", bookingDetails.getMovieId());
        }
    }

    @Override
    public BookingDetails getBookingDetails(String bookingId) {
        return bookingMongoRepository.findById(bookingId).map(bookingDocument -> {
           BookingDetails b = new BookingDetails();
           b.setMovieName(bookingDocument.getMovieName());
           b.setMovieId(bookingDocument.getMovieId());
           b.setBookingId(bookingDocument.getId());
           b.setSeats(bookingDocument.getSeats());
           b.setSlot(new Slot(bookingDocument.getStartTime(), bookingDocument.getEndTime()));
           b.setUserId(bookingDocument.getUserId());
           return b;
        }).orElse(null);
    }

    @Override
    public List<BookingDetails> getBookings(String userId) {
        return bookingMongoRepository.findByUserId(userId).stream().map(bd -> {
            BookingDetails b = new BookingDetails();
            b.setBookingId(bd.getId());
            b.setSeats(bd.getSeats());
            b.setMovieId(bd.getMovieId());
            b.setSlot(new Slot(bd.getStartTime(), bd.getEndTime()));
            b.setUserId(userId);
            return b;
        }).collect(Collectors.toList());
    }
}
