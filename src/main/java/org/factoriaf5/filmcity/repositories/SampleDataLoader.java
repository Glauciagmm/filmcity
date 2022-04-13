package org.factoriaf5.filmcity.repositories;

import org.factoriaf5.filmcity.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class SampleDataLoader {

    private final MovieRepository movieRepository;

    @Autowired
    public SampleDataLoader(MovieRepository movieRepository){

        this.movieRepository = movieRepository;
    }

    @PostConstruct
    public void addSampleMovies() {
        if (movieRepository.findAll().isEmpty()) {
            List<Movie> movies = List.of(
            new Movie("La História Interminable",
                            "https://www.ecartelera.com/carteles/6200/6228/003.jpg",
                            "Wolfgang Petersen",
                            1984,
                            "La Emperatriz Infantil está mortalmente enferma y su reino, Fantasia, corre un grave peligro. La salvación depende de Atreyu, un valiente guerrero de la tribu de los pieles verdes, y Bastian, un niño tímido que lee con pasión un libro mágico. Solo un ser humano puede salvar este lugar encantado.",
                            true,
                            "Paula",
                            5),

            new Movie("Batman",
                            "https://diseñocarteles.com/graficos/batman/1989-batman.jpg",
                            "Tim Burton",
                            1989,
                            "Bruce Wayne (Michael Keaton, 'Bitelchús'), traumatizado por el asesinato de sus padres cuando era niño, se disgusta al ver como Gotham, su ciudad natal, se ha convertido en un lugar del pecado.",
                            false,
                            null,
                            4),

            new Movie("Indiana Jones Y el Templo Maldito",
                            "https://1.bp.blogspot.com/-HaPJahElLfg/X8EdLLJw3eI/AAAAAAAALD8/wv2eUWUfmBwtQVwdxWzg0PI-ZuMHA76ugCLcBGAsYHQ/s1500/P%25C3%25B3ster%2Bpel%25C3%25ADcula%2BIndiana%2BJones%2By%2Bel%2Btemplo%2Bmaldito.jpg",
                            "Steven Spielberg",
                            1984,
                            " El arqueólogo y aventurero Indiana Jones está de vuelta. Persigue a una terrible secta que ha robado una joya sagrada dotada de poderes fabulosos. Una cantante de cabaret y un muchacho distraído le ayudarán a enfrentarse a los peligros más increíbles.",
                            true,
                            "Brian de Palma",
                            2),
            new Movie("El Color purpura",
                            "https://es.web.img3.acsta.net/r_1920_1080/img/01/f9/01f90f60ddc942042c0800df54f830d2.jpg",
                            "Steven Spielberg",
                            1985,
                            "Lindsay Lohan stars as Cady Heron, a 16 year old homeschooled girl who not only makes the mistake of falling for Aaron Samuels (Jonathan Bennett), the ex-boyfriend of queenbee Regina George (Rachel McAdams), but also unintentionally joins The Plastics, led by Regina herself.",
                            false,
                            null,
                            4),
            new Movie("Lady Bird",
                            "https://pics.filmaffinity.com/Lady_Bird-546261513-large.jpg",

                            "Greta Gerwig",
                            2017,
                            "Christine 'Lady Bird' McPherson (Saoirse Ronan) is a senior at a Catholic high school in Sacramento, California in 2002. She longs to attend a prestigious college in 'a city with culture'.",
                            true,
                            "Andrea",
                            4),
            new Movie("Suffragette",
                            "https://musicart.xboxlive.com/7/b81f2600-0000-0000-0000-000000000002/504/image.jpg?w=1920&h=1080",
                            "Sarah Gavron",
                            2015,
                            "Inspired by true events, Suffragette movingly explores the passion and heartbreak of those who risked all they had for women's right to vote – their jobs, their homes, their children, and even their lives.",
                            false,
                            null,
                            2),
            new Movie("On the basis of sex",
                            "https://m.media-amazon.com/images/I/71TuUvNkS4L._SL1500_.jpg",
                            "Mimi Leder",
                            2018,
                            "On the Basis of Sex is inspired by the true story of a young Ruth Bader Ginsburg – then a struggling attorney and new mother – who faces adversity and numerous obstacles in her fight for equal rights throughout her career.",
                            false,
                            null,
                            2)

            // Añadir aqui todas las pelis del catálogo!!
            );

            movieRepository.saveAll(movies);
        }
    }
}