package org.factoriaf5.filmcity;

import org.factoriaf5.filmcity.domain.Movie;
import org.factoriaf5.filmcity.repositories.MovieRepository;
import org.hamcrest.Matcher;
//import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTests {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    MovieRepository movieRepository;


    @BeforeEach
    void setUp() {
        movieRepository.deleteAll();
    }

    @Test
    void returnsTheExistingMovies() throws Exception {

        addSampleMovies();

        mockMvc.perform(get("/movies")) //libreria que simula peticiones o request http
                .andExpect(status().isOk()) // siempre devuleve un codigo de estado - codigo 200 significa que está ok
                .andExpect(jsonPath("$[*]", hasSize(2))) // prueba que la respuesta devuelve el objeto con 2 elementos
                .andExpect(jsonPath("$[0].title", equalTo("Jurassic Park"))) // primera pelicula su titulo es jurassic park y vas probando todos los campos
                .andExpect(jsonPath("$[0].coverImage", equalTo("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oU7Oq2kFAAlGqbU4VoAE36g4hoI.jpg")))
                .andExpect(jsonPath("$[0].director", equalTo("Steven Spielberg")))
                .andExpect(jsonPath("$[0].year", equalTo(1993)))
                .andExpect(jsonPath("$[0].synopsis", equalTo("A wealthy entrepreneur secretly creates a theme park featuring living dinosaurs drawn from prehistoric DNA.")))
                .andExpect(jsonPath("$[1].title", equalTo("Ratatouille")))
                .andExpect(jsonPath("$[1].coverImage", equalTo("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/npHNjldbeTHdKKw28bJKs7lzqzj.jpg")))
                .andExpect(jsonPath("$[1].director", equalTo("Brad Bird")))
                .andExpect(jsonPath("$[1].year", equalTo(2007)))
                .andExpect(jsonPath("$[1].synopsis", equalTo("Remy, a resident of Paris, appreciates good food and has quite a sophisticated palate. He would love to become a chef so he can create and enjoy culinary masterpieces to his heart's delight. The only problem is, Remy is a rat.")))
                .andDo(print()); //imprime el catalogo de peliculas
    }

    private void addSampleMovies() {
        List<Movie> movies = List.of(
                new Movie("Jurassic Park",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oU7Oq2kFAAlGqbU4VoAE36g4hoI.jpg",
                        "Steven Spielberg",
                        1993,
                        "A wealthy entrepreneur secretly creates a theme park featuring living dinosaurs drawn from prehistoric DNA."),
                new Movie("Ratatouille",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/npHNjldbeTHdKKw28bJKs7lzqzj.jpg",
                        "Brad Bird",
                        2007,
                        "Remy, a resident of Paris, appreciates good food and has quite a sophisticated palate. He would love to become a chef so he can create and enjoy culinary masterpieces to his heart's delight. The only problem is, Remy is a rat.")
        );

        movieRepository.saveAll(movies);
    }
    @Test
    void allowsToDeleteAMovieById() throws Exception {
        Movie movie = movieRepository.save(new Movie("Avatar", "Azul", "xxx", 2015, "Java"));
        mockMvc.perform(delete("/api/movies/"+ movie.getMovieId()))
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

}