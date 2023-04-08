package golive.demo.hexagonal.adapters.incoming.web;

import golive.demo.hexagonal.bookmymovie.dto.MovieDetails;
import golive.demo.hexagonal.bookmymovie.exceptions.MovieException;
import golive.demo.hexagonal.bookmymovie.ports.incoming.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/movies")
public class MovieWebResource {

    @Autowired
    Movie movie;

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<MovieDetails>> getMovies() throws MovieException {
        return ResponseEntity.ok(movie.getMovies());
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Void> save(@RequestBody MovieDetails movieDetails) throws MovieException {
        movie.createMovie(movieDetails);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
