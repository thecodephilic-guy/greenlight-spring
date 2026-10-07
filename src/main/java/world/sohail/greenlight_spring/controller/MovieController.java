package world.sohail.greenlight_spring.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import world.sohail.greenlight_spring.entity.Movie;
import world.sohail.greenlight_spring.repository.MovieRepository;
import world.sohail.greenlight_spring.movie.dto.CreateMovieRequest;
import world.sohail.greenlight_spring.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/v1/movies")
public class MovieController {
    private final MovieRepository movieRepository;
    private final MovieService movieService;

    public MovieController(MovieRepository movieRepository, MovieService movieService) {
        this.movieRepository = movieRepository;
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@Valid @RequestBody CreateMovieRequest request) {
        Movie movie = new Movie(request.title(), request.year(), request.runtime(), request.genres(),
                request.imageUrl(), request.synopsis());
        Movie saved = movieRepository.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movies = movieService.getMovies();

        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }
}
