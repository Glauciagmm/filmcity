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
                    4),
            new Movie("STAR WARS V: El imperio contrataca",
                    "https://es.web.img2.acsta.net/r_1280_720/medias/nmedia/18/72/73/89/20535463.jpg",
                    "Irvin Kershner",
                    1980,
                    "Tras un ataque sorpresa de las tropas imperiales a las bases camufladas de la alianza rebelde, Luke Skywalker, en compañía de R2D2, parte hacia el planeta Dagobah en busca de Yoda, el último maestro Jedi, para que le enseñe los secretos de la Fuerza. Mientras, Han Solo, la princesa Leia, Chewbacca, y C3PO esquivan a las fuerzas imperiales y piden refugio al antiguo propietario del Halcón Milenario, Lando Calrissian, en la ciudad minera de Bespin, donde les prepara una trampa urdida por Darth Vader",
                    true,
                    "Titi",
                    4),
            new Movie("Terminator",
                    "https://m.media-amazon.com/images/I/715jsfcSxfL._AC_SY606_.jpg",
                    "James Cameron",
                    1984,
                    "Los Ángeles, año 2029. Las máquinas dominan el mundo. Los rebeldes que luchan contra ellas tienen como líder a John Connor, un hombre que nació en los años ochenta. Para acabar con la rebelión, las máquinas deciden enviar al pasado a un robot -Terminator- cuya misión será eliminar a Sarah Connor, la madre de John, e impedir así su nacimiento. ",
                    false,
                    null,
                    3),
            new Movie("Los intocables de Elliot Ness",
                    "https://es.web.img3.acsta.net/medias/nmedia/18/68/09/79/20099212.jpg",
                    "Brian de Palma",
                    1987,
                    "Chicago, 1930.La ciudad está controlada por los gánsters de Al Capone. Elliot Ness es un agente incorruptible al servicio de la Ley seca que se propone apresarlos reuniendo a un grupo de hombres con la intención de llegar hasta los archivos de la banda y encontrar pruebas para poder desmantelarla.",
                    false,
                    null,
                    4),
            new Movie("El club de los cinco",
                    "https://static.filmin.es/images/media/27663/1/poster_0_3_338x507.png",
                    "John Hughes",
                    1985,
                    "Cinco alumnos de un instituto son castigados a pasar el sábado en la biblioteca del centro, vigilados por un estricto maestro. Una vez allí, los cinco compañeros, que creían que no tenían nada en común, empiezan una relación que les hará protagonistas de situaciones inesperadas. ",
                    false,
                    null,
                    5),
            new Movie("El Padrino",
                    "https://www.cineytele.com/wp-content/uploads/2018/06/el_padrino_poster.jpg",
                    "Francis Ford Coppola",
                    1972,
                    "América, años 40. Don Vito Corleone (Marlon Brando) es el respetado y temido jefe de una de las cinco familias de la mafia de Nueva York. Tiene cuatro hijos: Connie (Talia Shire), el impulsivo Sonny (James Caan), el pusilánime Fredo (John Cazale) y Michael (Al Pacino), que no quiere saber nada de los negocios de su padre. Cuando Corleone, en contra de los consejos de 'Il consigliere' Tom Hagen (Robert Duvall), se niega a participar en el negocio de las drogas, el jefe de otra banda ordena su asesinato. Empieza entonces una violenta y cruenta guerra entre las familias mafiosas.",
                    false,
                    null,
                    4),





            // Añadir aqui todas las pelis del catálogo!!
            );

            movieRepository.saveAll(movies);
        }
    }
}