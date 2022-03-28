package org.factoriaf5.filmcity.domain;

import javax.persistence.*;

@Entity
@Table(name = "MOVIE")
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
    @Column (name = "BOOK")
    private boolean book;
    @Column (name= "RENTER")
    private String renter;
    @Column (name="RATING")
    private int rating;
    @Column (name = "FIRSTNAME")
    private String firstName;




    public Movie() { }

    public Movie(String title, String coverImage, String director, int year, String synopsis, boolean book, String renter, int rating) {
        this.title = title;
        this.coverImage = coverImage;
        this.director = director;
        this.year = year;
        this.synopsis = synopsis;
        this.book = book;
        this.renter = renter;
        this.rating = rating;
        this.firstName = firstName;


    }

    public Long getMovieId() {
        return movieId;
    }


    public void setMovieId(Long movieId) {
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

    public boolean setBook() { return false; }

    public void setRenter(String renter) { this.renter = renter; }

    public int getRating() { return rating; }

    public void setRating(int rating) {this.rating = rating; }

    public String getFirstName() {return firstName; }

}

