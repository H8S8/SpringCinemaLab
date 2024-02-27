package com.example.SpringCinemaLab.components;

import com.example.SpringCinemaLab.models.Movie;
import com.example.SpringCinemaLab.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    MovieRepository movieRepository;

    Movie movie1 = new Movie("Interstellar", "12", 240);
    Movie movie2 = new Movie("Ponyo", "U", 130);
    Movie movie3 = new Movie("Amelie", "15", 122);
    Movie movie4 = new Movie("Fantastic Mr Fox", "PG", 110);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);
        movieRepository.save(movie4);
    }
}