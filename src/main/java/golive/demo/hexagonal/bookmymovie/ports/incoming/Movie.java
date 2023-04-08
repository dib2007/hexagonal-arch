package golive.demo.hexagonal.bookmymovie.ports.incoming;

import golive.demo.hexagonal.bookmymovie.dto.MovieDetails;
import golive.demo.hexagonal.bookmymovie.exceptions.MovieException;

import java.util.List;

public interface Movie {
    List<MovieDetails> getMovies() throws MovieException;
    void createMovie(MovieDetails movieDetails) throws MovieException;
}
