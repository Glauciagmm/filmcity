package org.factoriaf5.filmcity.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "movie not found")
public class MovieNotFoundException extends RuntimeException {
}
