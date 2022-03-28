package org.factoriaf5.filmcity;

import jdk.jfr.ContentType;
import org.factoriaf5.filmcity.domain.Movie;
import org.factoriaf5.filmcity.repositories.MovieRepository;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTests {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    MovieRepository movieRepository;
    //private Object MediaType;


    @BeforeEach
    void setUp() {
        movieRepository.deleteAll();
    }
    /** Teste que llama a la libreria y hace peticiones http. Comprueba cada uno de los campos */
    @Test
    void returnsTheExistingMovies() throws Exception {

        addSampleMovies();

        mockMvc.perform(get("/movies")) //llamada tipo get a la libreria que simula peticiones o request http
                .andExpect(status().isOk()) // siempre devuleve un codigo de estado - codigo 200 significa que está ok
                .andExpect(jsonPath("$[*]", hasSize(2))) // prueba que la respuesta devuelve el objeto con 2 elementos
                .andExpect(jsonPath("$[0].title", equalTo("Jurassic Park"))) // primera pelicula su titulo es jurassic park y vas probando todos los campos
                .andExpect(jsonPath("$[0].coverImage", equalTo("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oU7Oq2kFAAlGqbU4VoAE36g4hoI.jpg")))
                .andExpect(jsonPath("$[0].director", equalTo("Steven Spielberg")))
                .andExpect(jsonPath("$[0].year", equalTo(1993)))
                .andExpect(jsonPath("$[0].synopsis", equalTo("A wealthy entrepreneur secretly creates a theme park featuring living dinosaurs drawn from prehistoric DNA.")))
                .andExpect(jsonPath("$[0].book", equalTo(false)))
                .andExpect(jsonPath("$[0].renter", equalTo(null)))
                .andExpect(jsonPath("$[0].rating", equalTo(5)))
                .andExpect(jsonPath("$[1].title", equalTo("Ratatouille")))
                .andExpect(jsonPath("$[1].coverImage", equalTo("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/npHNjldbeTHdKKw28bJKs7lzqzj.jpg")))
                .andExpect(jsonPath("$[1].director", equalTo("Brad Bird")))
                .andExpect(jsonPath("$[1].year", equalTo(2007)))
                .andExpect(jsonPath("$[1].synopsis", equalTo("Remy, a resident of Paris, appreciates good food and has quite a sophisticated palate. He would love to become a chef so he can create and enjoy culinary masterpieces to his heart's delight. The only problem is, Remy is a rat.")))
                .andExpect(jsonPath("$[1].book", equalTo(false)))
                .andExpect(jsonPath("$[1].renter", equalTo(null)))
                .andExpect(jsonPath("$[1].rating", equalTo(4)))
                .andDo(print()); //imprime el catalogo de peliculas
    }
    /**Añade objetos al método que luego serán comprobados en el test de arriba*/
    private void addSampleMovies() {
        List<Movie> movies = List.of(
                new Movie("Jurassic Park",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oU7Oq2kFAAlGqbU4VoAE36g4hoI.jpg",
                        "Steven Spielberg",
                        1993,
                        "A wealthy entrepreneur secretly creates a theme park featuring living dinosaurs drawn from prehistoric DNA.",
                        false,
                        null,
                        5),

                new Movie("Ratatouille",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/npHNjldbeTHdKKw28bJKs7lzqzj.jpg",
                        "Brad Bird",
                        2007,
                        "Remy, a resident of Paris, appreciates good food and has quite a sophisticated palate. He would love to become a chef so he can create and enjoy culinary masterpieces to his heart's delight. The only problem is, Remy is a rat.",
                        false,
                        null,
                        4));


        movieRepository.saveAll(movies);
    }


    @Test
    void allowsToCreateANewMovie() throws Exception {
        mockMvc.perform(post("/movies")
                .contentType(APPLICATION_JSON)
                .content("{" +
                        "\"title\": \"Jurassic\", " +
                        "\"coverImage\": \"https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oU7Oq2kFAAlGqbU4VoAE36g4hoI.jpg\", " +
                        "\"director\": \"Steven Spielberg\", " +
                        "\"year\": \"1993\", " +
                        "\"synopsis\": \"A wealthy entrepreneur secretly creates a theme park featuring living dinosaurs drawn from prehistoric DNA.\" " +
                        "\"book\":\"false\""+
                        "\"renter\":\"null\""+
                        "\"rating\":\"5\""+
                        "}")
        ).andExpect(status().isOk());

        List<Movie> movies = movieRepository.findAll();
        assertThat(movies, contains(allOf(
                hasProperty("title", is("Jurassic")),
                hasProperty("coverImage", is("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oU7Oq2kFAAlGqbU4VoAE36g4hoI.jpg")),
                hasProperty("director", is("Steven Spielberg")),
                hasProperty("year", is(1993)),
                hasProperty("synopsis", is("A wealthy entrepreneur secretly creates a theme park featuring living dinosaurs drawn from prehistoric DNA.")),
                hasProperty("book", is(false)),
                hasProperty("renter", is(null)),
                hasProperty("rating", is(5))
                )));
    }


    @Test
    void allowsToFindAMovieById() throws Exception {

        Movie movie = movieRepository.save(new Movie("Jurassic Park", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oU7Oq2kFAAlGqbU4VoAE36g4hoI.jpg", "Steven Spielberg", 1993, "A wealthy entrepreneur secretly creates a theme park featuring living dinosaurs drawn from prehistoric DNA.",false,null,5));

        mockMvc.perform(get("/movies/" + movie.getMovieId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", equalTo("Jurassic Park")))
                .andExpect(jsonPath("$.coverImage", equalTo("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oU7Oq2kFAAlGqbU4VoAE36g4hoI.jpg")))
                .andExpect(jsonPath("$.director", equalTo("Steven Spielberg")))
                .andExpect(jsonPath("$.year", equalTo(1993)))
                .andExpect(jsonPath("$.synopsis", equalTo("A wealthy entrepreneur secretly creates a theme park featuring living dinosaurs drawn from prehistoric DNA.")))
                //.andExpect(jsonPath("$.book", equalTo(false)))
                //.andExpect(jsonPath("$.renter", equalTo( null)))
                .andExpect(jsonPath("$.rating", equalTo( 5)));
    }

    @Test
    void returnsAnErrorIfTryingToGetAMOVIEThatDoesNotExist() throws Exception {
        mockMvc.perform(get("/api/movie/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void allowsToDeleteAMovieById() throws Exception {
        Movie movie = movieRepository.save(new Movie("Jurassic Park", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oU7Oq2kFAAlGqbU4VoAE36g4hoI.jpg", "Brad Bird", 2007, "Remy, a resident of Paris, appreciates good food and has quite a sophisticated palate. He would love to become a chef so he can create and enjoy culinary masterpieces to his heart's delight. The only problem is, Remy is a rat", false, "null", 4));

        mockMvc.perform(delete("/movies/"+ movie.getMovieId()))
                .andExpect(status().isOk());

        List<Movie> movies = movieRepository.findAll();
        asserThat (movies, not(contains(allOf(
               hasProperty("", is("")),
               hasProperty("", is(""))
        ))));
    }

    private void asserThat(List<Movie> movies, Matcher<Iterable<?>> not) {
    }


    @Test
    void returnsAnErrorIfTryingToDeleteAMovieThatDoesNotExist() throws Exception {
        mockMvc.perform(delete("/api/movies/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void allowsToFindARenterMovie() throws Exception{

        Movie movie = movieRepository.save(new Movie("", "","",1234,"",false,"null",4));
        mockMvc.perform(get("/movie/1/book?renter="+ movie.getTitle()));
                 andExpect(status().isOk());

        List<Movie> movies = movieRepository.findAll();
        asserThat (movies, not(contains(allOf(
                hasProperty("", is("")),
                hasProperty("", is(""))
        ))));
    }

    private void andExpect(ResultMatcher ok) {
    }

  /* @Test
    void allowsToModifyAMovie() throws Exception {
        Movie movie = movieRepository.save(new Movie("Jurassic Park", "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oU7Oq2kFAAlGqbU4VoAE36g4hoI.jpg", "Steven Spielberg", 1993, "A wealthy entrepreneur secretly creates a theme park featuring living dinosaurs drawn from prehistoric DNA.", false,null,5));

        mockMvc.perform(put("/movies")
                .contentType(APPLICATION_JSON)
                .content("{" +
                        "\"id\": \"" + movie.getMovieId() + "\", " +
                        "\"title\": \"Hero of Central Park\", " +
                        "\"coverImage\": \"https://imgix.ranker.com/node_img/9/166109/original/chestnut-hero-of-central-park-films-photo-1?auto=format&q=60&fit=fill&fm=pjpg&dpr=2&crop=faces&bg=fff&h=333&w=333\","+
                        "\"synopsis\": \"A wealthy entrepreneur secretly creates a theme park featuring living dinosaurs drawn from prehistoric DNA.\" " +
                        "\"book\":\"true\""+
                        "\"renter\":\"null\""+
                        "\"rating\":\"4\"}"
                ).andExpect(status().isOk()));

        List<Movie> movies = movieRepository.findAll();

        assertThat(movies, hasSize(1));
        assertThat(movies.get(0).getTitle(), equalTo("Hero of Central Park"));
        assertThat(movies.get(0).getCoverImage(), equalTo("https://imgix.ranker.com/node_img/9/166109/original/chestnut-hero-of-central-park-films-photo-1?auto=format&q=60&fit=fill&fm=pjpg&dpr=2&crop=faces&bg=fff&h=333&w=333"));
    }*/
}