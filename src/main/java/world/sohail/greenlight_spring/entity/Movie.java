package world.sohail.greenlight_spring.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();

    @Column(nullable = false, length = 500)
    private String title;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer runtime;

    @JdbcTypeCode(SqlTypes.ARRAY) // Maps java list to postgres Text[]
    @Column(name = "genres", nullable = false, length = 50)
    private List<String> genres = new ArrayList<>();

    @Column(name = "image_url", nullable = false, length = 2048)
    private String imageUrl;

    @Column(nullable = false, length = 1000)
    private String synopsis;

    @Version // Tells Hibernate to handle optimistic locking automatically
    @Column(nullable = false)
    private Integer version;

    protected Movie() {}

    // 2. All-Arguments Constructor (Convenient for creating test data/instances)
    public Movie(String title, Integer year, Integer runtime, List<String> genres, String imageUrl, String synopsis) {
        this.title = title;
        this.year = year;
        this.runtime = runtime;
        this.genres = genres;
        this.imageUrl = imageUrl;
        this.synopsis = synopsis;
        // id, createdAt, and version are handled automatically by the DB and Hibernate
    }

    // Getters and Setters:

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    // 4. Equals and HashCode (Crucial for Hibernate collections and tracking changes)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
