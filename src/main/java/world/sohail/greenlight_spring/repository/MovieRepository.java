package world.sohail.greenlight_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import world.sohail.greenlight_spring.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {}
