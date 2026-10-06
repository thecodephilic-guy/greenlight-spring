package world.sohail.greenlight_spring.movie.dto;

import world.sohail.greenlight_spring.entity.Movie;

import java.util.List;

public record MovieResponse(Long id, String title, Integer year, Integer runtime,
                            List<String> genres, String imageUrl, String synopsis) {
    public static MovieResponse from(Movie movie) {
        return new MovieResponse(movie.getId(), movie.getTitle(), movie.getYear(), movie.getRuntime(),
                movie.getGenres(), movie.getImageUrl(), movie.getSynopsis());
    }
}
