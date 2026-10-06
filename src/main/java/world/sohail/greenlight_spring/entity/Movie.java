package world.sohail.greenlight_spring.entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String title;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer runtime;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "movie_genres", joinColumns = @JoinColumn(name = "movie_id"))
    @OrderColumn(name = "genre_order")
    @Column(name = "genre", nullable = false, length = 50)
    private List<String> genres = new ArrayList<>();

    @Column(name = "image_url", nullable = false, length = 2048)
    private String imageUrl;

    @Column(nullable = false, length = 1000)
    private String synopsis;

    protected Movie() {}

    public Movie(String title, Integer year, Integer runtime, List<String> genres, String imageUrl, String synopsis) {
        this.title = title;
        this.year = year;
        this.runtime = runtime;
        this.genres = new ArrayList<>(genres);
        this.imageUrl = imageUrl;
        this.synopsis = synopsis;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public Integer getYear() { return year; }
    public Integer getRuntime() { return runtime; }
    public List<String> getGenres() { return List.copyOf(genres); }
    public String getImageUrl() { return imageUrl; }
    public String getSynopsis() { return synopsis; }
}
