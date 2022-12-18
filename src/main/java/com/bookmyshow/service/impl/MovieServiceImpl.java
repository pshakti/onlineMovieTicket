package com.bookmyshow.service.impl;

import com.bookmyshow.entity.Movie;
import com.bookmyshow.entity.Screening;
import com.bookmyshow.entity.ShowDetails;
import com.bookmyshow.exception.MovieNotFoundException;
import com.bookmyshow.model.MovieDto;
import com.bookmyshow.repository.MovieRepository;
import com.bookmyshow.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.naming.ServiceUnavailableException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    private final ModelMapper modelMapper;


    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(String movieId) {
        return movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException(movieId));
    }

    @Override
    public Movie addMovie(MovieDto newMovie) throws ServiceUnavailableException {
        Movie movie=modelMapper.map(newMovie,Movie.class);
        movie.setMovieId(UUID.randomUUID().toString());

       Set<Screening> screenings=movie.getScreenings().stream().map(i-> {

           List<ShowDetails> showDetails = i.getShow().stream()
                   .map(k -> {
                       k.setScreeningId(UUID.randomUUID().toString());
                       return k;
                   }).collect(Collectors.toList());

           i.setShow(showDetails);
           return i;
       }).collect(Collectors.toSet());

       movie.setScreenings(screenings);
        try {
            movie= movieRepository.save(movie);
        }catch (Exception e)
        {
            log.info("Exception while adding the new theatre in dataBase , EXCEPTION {}",e.getMessage());
            throw new ServiceUnavailableException();
        }

        return movie;
    }
    @Override
    public List<Screening> getAllScreeningByMovieId(String movieId) {
        Movie movie = getMovieById(movieId);
        return new ArrayList<>(movie.getScreenings());
    }

    @Override
    public void deleteMovie(String movie_id) {
        movieRepository.deleteById(movie_id);
    }

    @Override
    public List<Screening> getAllScreeningByMovieIdAndDate(String movie_id, LocalDate date) {
        Movie movie = getMovieById(movie_id);
        //return movie.getMovieTheatres().stream().filter(screening -> screening.getDate().equals(date)).collect(Collectors.toList());
        return null;
    }
}
