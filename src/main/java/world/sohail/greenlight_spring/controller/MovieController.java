package world.sohail.greenlight_spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import world.sohail.greenlight_spring.dto.ApiResponse;
import world.sohail.greenlight_spring.entity.Movie;
import world.sohail.greenlight_spring.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/v1/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Movie>>> getMovies() {
        List<Movie> movies = movieService.getMovies();

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success("List of all movies in the database", movies));
    }
}
