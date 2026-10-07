package world.sohail.greenlight_spring.service;

import org.springframework.stereotype.Service;
import world.sohail.greenlight_spring.entity.Movie;
import world.sohail.greenlight_spring.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public  MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }
}
