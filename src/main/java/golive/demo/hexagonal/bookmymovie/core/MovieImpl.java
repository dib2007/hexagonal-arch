package golive.demo.hexagonal.bookmymovie.core;

import golive.demo.hexagonal.bookmymovie.dto.MovieDetails;
import golive.demo.hexagonal.bookmymovie.exceptions.MovieException;
import golive.demo.hexagonal.bookmymovie.ports.incoming.Movie;
import golive.demo.hexagonal.bookmymovie.ports.outgoing.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieImpl implements Movie {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<MovieDetails> getMovies() {
        return movieRepository.getMovies();
    }

    @Override
    public void createMovie(MovieDetails movieDetails) throws MovieException {
        movieRepository.save(movieDetails);
    }
}
