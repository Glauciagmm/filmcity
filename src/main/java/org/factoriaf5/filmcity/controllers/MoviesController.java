package org.factoriaf5.filmcity.controllers;

import org.factoriaf5.filmcity.domain.Movie;
import org.factoriaf5.filmcity.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.text.StringCharacterIterator;
import java.util.List;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;

/**@RestControler es una anotación de classe que se encarga de recibir las peticiones HTTP - analisa los datos que llegan de la peticion */
@RestController

public class MoviesController {

    private final MovieRepository movieRepository;

    @Autowired
    MoviesController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    /**Es una anotación que espera la peticion  de metodo GET para la ruta /movies - cuanto la encuetra ejecuta la funcion de encontrar todas las peliculas del repositório. */
    @GetMapping("/movies")
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    /**Es una anotación que espera la peticion  de metodo GET para la ruta /movies - cuanto la encuetra ejecuta la funcion de encontrar en el repositório una pelicula segun su Id. */
    @GetMapping("/movies/{id}")
    public Movie findMovie(@PathVariable Long id) {
        return movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
    }

    /** Es una anotación que espera la peticion  de metodo POST para la ruta /movies - cuanto la encuetra ejecuta la funcion de añadir una pelicula al repositório.*/
    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    /**Es una anotación que espera la peticion  de metodo DELETE para la ruta /movies - cuanto la encuetra ejecuta la funcion de deletar la pelicula segun su Id. */
    @DeleteMapping("/movies/{id}")
    public Movie deleteMovieById(@PathVariable Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
        movieRepository.deleteById(id);
        return movie;
    }

    /** Es una anotación que espera la peticion  de metodo PUT para la ruta /movies - cuanto la encuetra ejecuta la función de modificar los datos de una pelicula. */
    @PutMapping("/movies")
    public Movie updateMovieById(@RequestBody Movie movie) {
        movieRepository.findById(movie.getMovieId()).orElseThrow(MovieNotFoundException::new);
        return movieRepository.save(movie);
    }

    /**Encuentra la pelicula por su Id, la Marca como alquilada la película con el id {id} y registra el nombre de quien la ha alquilado
     * @return*/
    @PutMapping("/movie/{id}/book")
    public Movie upDateMovieRented(@RequestBody Movie movie) {
        movieRepository.findById(movie.getMovieId()).orElseThrow(MovieNotFoundException::new);
        movie.setRenter(null);
        movie.setBook();
        String firstName = "Julia";


        if (movie.setBook()) {
            return movieRepository.getById().getTitle();
        } else {
            return movieRepository.getById(movie.getTitle() + firstName);
        }

    /** Marca una pelicula como disponible */
    @PutMapping("/movies/{id}/renter")
    public Movie clearMovieRented(@PathVariable long movieId){
        Movie movie = movieRepository.findById(movieId).orElseThrow(MovieNotFoundException::new);
        movie.setRenter(null);
        movie.setBook();
        return movieRepository.save(movie);
    }


    @PutMapping("/movies/{id}/rating")
    public Movie upDateRatingMovieById(@PathVariable long movieid, @RequestBody Movie movie){
        Movie movieToEdit = movieRepository.findById(movieid).orElseThrow(MovieNotFoundException::new);
        int newRating = movie.getRating();
        if(newRating >=0 && newRating <=5){
            movieToEdit.setRating(newRating);
        } else {  newRating = 0;
        }
            return movieRepository.save(movieToEdit);
        }
    //hay que pensar en los casos que poden estropear el codigo. poner un mensaje en el caso de dato incorrecto
}

