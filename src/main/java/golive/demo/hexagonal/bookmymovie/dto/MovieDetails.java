package golive.demo.hexagonal.bookmymovie.dto;

import lombok.Data;

import java.util.List;

@Data
public class MovieDetails {
    private String movieId;
    private String movieName;
    private List<String> actors;
    private List<Slot> availableSlots;
}
