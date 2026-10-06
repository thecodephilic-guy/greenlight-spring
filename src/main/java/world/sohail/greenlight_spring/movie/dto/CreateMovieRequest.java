package world.sohail.greenlight_spring.movie.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

public record CreateMovieRequest(
        @NotBlank(message = "must be provided")
        @Size(max = 500, message = "must not be more than 500 characters long")
        String title,

        @NotNull(message = "must be provided")
        @Min(value = 1888, message = "must be at least 1888")
        Integer year,

        @NotNull(message = "must be provided")
        @Positive(message = "must be a positive integer")
        Integer runtime,

        @NotNull(message = "must be provided")
        @Size(min = 1, max = 5, message = "must contain between 1 and 5 genres")
        @UniqueElements(message = "must not contain duplicate values")
        List<@NotBlank @Size(max = 50) String> genres,

        @NotBlank(message = "must be provided")
        @URL(message = "must be a valid URL")
        String imageUrl,

        @NotBlank(message = "must be provided")
        @Size(min = 10, max = 1000, message = "must be between 10 and 1000 characters")
        String synopsis
) {}
