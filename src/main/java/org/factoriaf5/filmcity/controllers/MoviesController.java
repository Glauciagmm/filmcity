package org.factoriaf5.filmcity.controllers;

import org.factoriaf5.filmcity.domain.Movie;
import org.factoriaf5.filmcity.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**@RestControler es una anotación de classe que se encarga de recibir las peticiones HTTP - analisa los datos que llegan de la peticion */
@RestController
@CrossOrigin(origins="http://127.0.0.1:5500/")
public class MoviesController{

    @Autowired
    private final MovieRepository movieRepository;

    MoviesController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    /**Es una anotación que espera la petición  de método GET para la ruta "/movies" -
     * cuanto la encuetra ejecuta la función (findAll) de encontrar todas las peliculas del repositório. */
    @GetMapping("/movies")
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    /**Es una anotación que espera la petición  de método GET para la ruta /"movies/{id}" -
     * cuanto la encuetra ejecuta la función de encontrar en el repositório una pelicula segun su Id,
     * si no la encuentra devuelve que la película no fue encontrada */
    @GetMapping("/movies/{id}")
    public Movie findMovie(@PathVariable Long id) {
        return movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
    }
/**
    @GetMapping("/moviess/{id}")
    public ResponseEntity<Movie> getUserByID(@PathVariable long id) {
        //Es un Optional<T>
        Optional<Movie> u = movieRepository.findById(id);
        //Si está presente lo devolvemos
        if(movie.isPresent()){
            return ResponseEntity.ok(movie.get());
        }
        //Si no, lanzamos un error
        else{
            throw new ChangeSetPersister.NotFoundException("Not found Movie by id: " + id);
        }
    }*/

    /** Es una anotación que espera la petición  de metodo POST para la ruta "/movies" -
     * cuanto la encuetra ejecuta la función de añadir una película al repositório.*/
    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    /**Es una anotación que espera la petición  de método DELETE para la ruta "/movies/{id}" -
     * cuanto la encuetra ejecuta la función de borrar la película según su Id. */
    @DeleteMapping("/movies/{id}")
    public Movie deleteMovieById(@PathVariable Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
        movieRepository.deleteById(id);
        return movie;
    }

    /** Es una anotación que espera la petición  de método PUT para la ruta "/movies" -
     * cuanto la encuetra ejecuta la función de modificar los datos de una película. */
    @PutMapping("/movies")
    public Movie updateMovieById(@RequestBody Movie movie) {
        //movieRepository.findById(movie.getId()).orElseThrow(MovieNotFoundException::new);
        return movieRepository.save(movie);
    }

    /**Encuentra la pelicula por su Id, la marca como alquilada de acuerdo con el id {id}, además,
     *  registra el nombre de quien la ha alquilado*/
    @PutMapping("/movies/{id}/book")
    public Movie updateMovieRented(@PathVariable Long id, @RequestParam (value = "renter") String renter) {
        Movie movie = movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
        movie.setRenter(renter);
        movie.setBook(true);
        return movieRepository.save(movie);
    }

    /** Marca una pelicula como disponible cuando borrando el nombre de quien la ha alquilado */
    @PutMapping("/movies/{id}/return")
    public Movie clearMovieRented(@PathVariable Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
        movie.setRenter(null);
        movie.setBook(false);
        return movieRepository.save(movie);
    }

    /**Atribuye un Score a las peliculas*/
    @PutMapping("/movies/{id}/rating")
    public Movie upDateRatingMovieById(@PathVariable Long id, @RequestBody Movie movie){
        Movie movieToEdit = movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
        int newRating = movie.getRating();
        if(newRating >=0 && newRating <=5){
            movieToEdit.setRating(newRating);
        } else {
            movieToEdit.setRating(0);
        }
            return movieRepository.save(movieToEdit);
        }
}