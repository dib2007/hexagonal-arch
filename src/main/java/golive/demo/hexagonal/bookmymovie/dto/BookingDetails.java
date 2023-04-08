package golive.demo.hexagonal.bookmymovie.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookingDetails {
    private String bookingId;
    private String movieId;
    private String userId;
    private List<String> seats;
    private String movieName;
    private Slot slot;
}
