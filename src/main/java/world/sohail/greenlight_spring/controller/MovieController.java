package world.sohail.greenlight_spring.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import world.sohail.greenlight_spring.entity.Movie;
import world.sohail.greenlight_spring.repository.MovieRepository;
import world.sohail.greenlight_spring.movie.dto.CreateMovieRequest;
import world.sohail.greenlight_spring.movie.dto.MovieResponse;

@RestController
@RequestMapping("/v1/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostMapping
    public ResponseEntity<MovieResponse> createMovie(@Valid @RequestBody CreateMovieRequest request) {
        Movie movie = new Movie(request.title(), request.year(), request.runtime(), request.genres(),
                request.imageUrl(), request.synopsis());
        Movie saved = movieRepository.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(MovieResponse.from(saved));
    }
}
