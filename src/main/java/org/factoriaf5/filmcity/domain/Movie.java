package org.factoriaf5.filmcity.domain;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long movieId;
    @Column (name = "TITLE")
    private String title;
    @Column (name = "COVERIMAGE")
    private String coverImage;
    @Column (name = "DIRECTOR")
    private String director;
    @Column (name = "YEAR")
    private int year;
    @Lob //tipo de dato binario
    private String synopsis;

    public Movie() { }

    public Movie(String title, String coverImage, String director, int year, String synopsis) {
        this.title = title;
        this.coverImage = coverImage;
        this.director = director;
        this.year = year;
        this.synopsis = synopsis;
    }

    public Long getMovieId() {
        return movieId;
    }


    public void setMovieId(Long id) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public String getSynopsis() {
        return synopsis;
    }
}