# FilmCity :clapper: :clapper: :tada: :tv: :tv: :tada: :clapper: :clapper: :tada:

## Información de la aplicación :computer:
FilmCity es un repositorio que incluye todos los archivos necesarios para tener el Back-end de un posible videoclub. :clapper: :tv:
Hemos usado el lenguaje de programación JAVA para crear una API Rest con su Base de Datos. Hemos usado Spring Boot y el JDK 17 de Java.

## Funcionalidades principales :computer:
Nuestro BACK-END de FilmCity permite:  :clapper:  :clapper:  :clapper:  :clapper:

1. Insertar nuevas películas en la base de datos.
2. Borrar películas de la base de datos.
3. Permite buscar películas dentro de la base de datos.
4. Permite marcar una película como alquilada y el nombre de la persona que la alquiló.
5. Permite borrar los datos y volver al estado anterior en la anotación de la película para que ésta vuelva a aparecer como disponible para volver a ser alquilada después.
6. También permite modificar los datos de una película de la base de datos, incluso añadir su puntuación en valores de de 0 a 5 puntos, a modo de valoración, para saber si una película es realmente interesante y saber si merece la pena verla o no.

## Guía de inicio :computer:

### Requisitos para la instalación

Para la instalación y el uso del BACK-END de FilmCity necesitaras tener:
1. Un software de tipo IDE (Entorno de desarrollo integrado) como por ejemplo INTELLIJ IDEA para modificar los archivos que clones en tu ordenador.
2. Necesitarás tambien tener GIT instalado en tu pc.
3. El siguiente paso es abrir tu IDE y abrir la terminal de GitBash y escribir los siguientes comandos:

- Iniciar GIT:
~~~
$git init
~~~
- CLONAR EL REPOSITORIO DE FILMCITY:
~~~
  $git clone https://github.com/Glauciagmm/filmcity.git
~~~

### Enlaces para clonar o bajar el repositorio :white_check_mark: :file_folder: :file_folder: :file_folder:

:file_folder: [Aquí](https://github.com/Glauciagmm/filmcity.git) tienes el enlace del Repositorio de FilmCity para clonarlo: [https://github.com/Glauciagmm/filmcity.git](https://github.com/Glauciagmm/filmcity.git)


:file_folder: [Haz click aquí](https://github.com/Glauciagmm/filmcity/archive/refs/heads/main.zip) para descargar el formato de archivo comprimido [.ZIP](https://github.com/Glauciagmm/filmcity/archive/refs/heads/main.zip)

### Conocimientos Requeridos

:ok_hand: 1. Java (JDK 17)

:ok_hand: 2. Spring Boot

:ok_hand: 3. API REST

:ok_hand: 4. Postman

:ok_hand: 5. IntelliJ IDEA (IDE)

:ok_hand: 6. XAMPP

:ok_hand: 7. Bases de Datos (phpMyAdmin)

:ok_hand: 8. Uso de LocalHost

# Arquitectura del Código

Existen varios archivos.



~~~
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
    }
~~~
