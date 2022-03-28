package org.factoriaf5.filmcity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**es la anotaciónd e Springboot que es el fichero de punto de entrada con el método main*/
@SpringBootApplication
public class FilmcityApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmcityApplication.class, args);
    }

}
//tenemos un servidor que se llama Tomcat - puerto 8080
//podemos comprabar si funciona en el navegador con localhost:8080/movies
//bajar el plugin jsonviwer y añaddir al crome

//tambien se puede hacer en el postman eligiendo el metodo GEt

// gete = metodo / LocalHost = ruta / 8080 = puerto / movies = peticion

//en nuestro proyecto tenemos 3 capas - cada una gestiona un tipo de funcionalidad
//controlers gestiona las peticiones del cliente
//cada carpeta/paquete es una capa
//
//
