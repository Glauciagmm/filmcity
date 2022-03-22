package org.factoriaf5.filmcity.repositories;

import org.factoriaf5.filmcity.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //para dar contexto - esta interfaz es un repositorio para realizar operaciones con la base de datos
public interface MovieRepository extends JpaRepository<Movie, Long> {} // interface

//una interfaz es como un contrato - espeficifa funcionalidades del trabajo a hacer, define las tareas pero no el como
//está creando el contracto y heredando las funcionalidades del repositorio del sprungboot