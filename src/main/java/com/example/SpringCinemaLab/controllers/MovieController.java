package com.example.SpringCinemaLab.controllers;

import com.example.SpringCinemaLab.models.Movie;
import com.example.SpringCinemaLab.services.MovieService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String response = movieService.addMovie(movie);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(){
        List<Movie> movies = movieService.getMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable long id){
        Optional<Movie> movie = movieService.getMovieById(id);
        if(movie.isEmpty()){
            return new ResponseEntity<>(movie, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable long id){
        Movie movie = movieService.getMovieById(id).get();
        movieService.deleteMovie(movie);
        return new ResponseEntity<>("Movie sucessfully deleted", HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Movie> updateRating(@RequestBody Movie newMovie, @PathVariable long id){
        Movie movie = movieService.updateMovie(id, newMovie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }


}
