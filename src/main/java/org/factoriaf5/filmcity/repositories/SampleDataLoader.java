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
            new Movie("El Color Púrpura",
                            "https://es.web.img3.acsta.net/r_1920_1080/img/01/f9/01f90f60ddc942042c0800df54f830d2.jpg",
                            "Steven Spielberg",
                            1985,
                            " Principios del siglo XX. Narra la historia de Celie, una adolescente negra de catorce años que está embarazada de su propio padre, un hombre despótico y cruel. A partir de entonces su vida estará llena de dolor y humillaciones.",
                            true,
                            "Brian de Palma",
                            2),
            new Movie("The Goonies",
                    "http://i0.kym-cdn.com/photos/images/original/000/536/544/d1f.jpg",
                    "Richard Donner",
                    1985,
                    "A group of young misfits called The Goonies discover an ancient map and set out on an adventure to find a legendary pirate's long-lost treasure.",
                    false,
                    null,
                    4),
            new Movie("Ghostbusters",
                    "https://pics.filmaffinity.com/Los_Cazafantasmas-295077476-mmed.jpg",
                    "Ivan Reitman",
                    1984,
                    "Three parapsychologists forced out of their university funding set up shop as a unique ghost removal service in New York City, attracting frightened yet skeptical customers.",
                    false,
                    null,
                    4),
            new Movie("Labyrinth",
                    "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1363470107l/10693439.jpg",
                    "Jim Henson",
                    1986,
                    "Sixteen-year-old Sarah is given thirteen hours to solve a labyrinth and rescue her baby brother Toby when her wish for him to be taken away is granted by the Goblin King Jareth.",
                    false,
                    null,
                    4),
            new Movie("Teen Wolf",
                    "https://pics.filmaffinity.com/Teen_Wolf_De_pelo_en_pecho-296776234-large.jpg",
                    "Rod Daniel",
                    1985,
                    "An ordinary high school student discovers that his family has an unusual pedigree when he finds himself turning into a werewolf.",
                    false,
                    null,
                    4),
            new Movie("Who framed roger rabbit",
                    "https://c4-static.dodax.com/v2/600-600-130549264_LeAwJ-png",
                    "Robert Zemeckis",
                    1988,
                    "A toon-hating detective is a cartoon rabbit's only hope to prove his innocence when he is accused of murder.",
                    false,
                    null,
                    4),
            new Movie("Willow",
                    "https://es.web.img2.acsta.net/medias/nmedia/18/82/00/27/20410202.jpg",
                    "Ron Howard",
                    1988,
                    "A young farmer is chosen to undertake a perilous journey in order to protect a special baby from an evil queen.",
                    false,
                    null,
                    4)

            // Añadir aqui todas las pelis del catálogo!!
            );

            movieRepository.saveAll(movies);
        }
    }
}