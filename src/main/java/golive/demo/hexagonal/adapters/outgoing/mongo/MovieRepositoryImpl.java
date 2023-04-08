package golive.demo.hexagonal.adapters.outgoing.mongo;

import golive.demo.hexagonal.bookmymovie.dto.MovieDetails;
import golive.demo.hexagonal.bookmymovie.ports.outgoing.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    @Autowired
    MovieMongoRepository movieMongoRepository;

    @Override
    public List<MovieDetails> getMovies() {
        return movieMongoRepository.findAll().stream().map(md -> {
            MovieDetails m = new MovieDetails();
            m.setMovieId(md.getId());
            m.setMovieName(md.getMovieName());
            m.setActors(md.getActors());
            m.setAvailableSlots(md.getSlots());
            return m;
        }).collect(Collectors.toList());
    }

    @Override
    public void save(MovieDetails movieDetails) {
        MovieDocument movieDocument = new MovieDocument();
        movieDocument.setMovieName(movieDetails.getMovieName());
        movieDocument.setActors(movieDetails.getActors());
        movieDocument.setSlots(movieDetails.getAvailableSlots());
        movieMongoRepository.save(movieDocument);
    }
}
