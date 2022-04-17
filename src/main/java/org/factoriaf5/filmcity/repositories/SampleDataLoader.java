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
                            "Principios del siglo XX. Narra la historia de Celie, una adolescente negra de catorce años que está embarazada de su propio padre, un hombre despótico y cruel. A partir de entonces su vida estará llena de dolor y humillaciones. ",
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
                            2),
            new Movie("The Goonies",
                    "https://m.media-amazon.com/images/I/911bXg9dQaL._AC_SL1500_.jpg",
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
                    "https://m.media-amazon.com/images/M/MV5BMjM2MDE4OTQwOV5BMl5BanBnXkFtZTgwNjgxMTg2NzE@._V1_UY1200_CR74,0,630,1200_AL_.jpg",
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