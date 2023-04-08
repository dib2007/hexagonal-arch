package golive.demo.hexagonal.bookmymovie.ports.outgoing;

import golive.demo.hexagonal.bookmymovie.dto.MovieDetails;

import java.util.List;

public interface MovieRepository {
    List<MovieDetails> getMovies();
    void save(MovieDetails movieDetails);
}
