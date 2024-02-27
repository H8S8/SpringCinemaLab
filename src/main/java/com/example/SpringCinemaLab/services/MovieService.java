package com.example.SpringCinemaLab.services;

import com.example.SpringCinemaLab.models.Movie;
import com.example.SpringCinemaLab.repositories.MovieRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public MovieService(){}

    public String addMovie(Movie movie){
        movieRepository.save(movie);
        return "Movie titled " + movie.getTitle() + " has been added to database.";
    }

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(long id){
        return movieRepository.findById(id);
    }

    public void deleteMovie(Movie movie){
        movieRepository.delete(movie);
    }

    public Movie updateMovie(long id, Movie newMovie){
        getMovieById(id).get().setTitle(newMovie.getTitle());
        getMovieById(id).get().setRating(newMovie.getRating());
        getMovieById(id).get().setDuration(newMovie.getDuration());
        return getMovieById(id).get();
    }


}
