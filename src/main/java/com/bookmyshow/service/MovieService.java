package com.bookmyshow.service;

import com.bookmyshow.entity.Movie;
import com.bookmyshow.entity.Screening;
import com.bookmyshow.model.MovieDto;

import javax.naming.ServiceUnavailableException;
import java.time.LocalDate;
import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie getMovieById(String movie_id);

    Movie addMovie(MovieDto newMovie) throws ServiceUnavailableException;

    void deleteMovie(String movie_id);

    List<Screening> getAllScreeningByMovieId(String movieId);

    List<Screening> getAllScreeningByMovieIdAndDate(String movie_id, LocalDate localDate);

}