package com.bookmyshow.service.impl;

import com.bookmyshow.entity.*;
import com.bookmyshow.exception.MovieNotFoundException;
import com.bookmyshow.exception.UserNotFoundException;
import com.bookmyshow.model.BookingDto;
import com.bookmyshow.model.BookingResponse;
import com.bookmyshow.repository.*;
import com.bookmyshow.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;

    private final MovieRepository movieRepository;

    private final UserRepository userRepository;

    private final TheatreRepository theatreRepository;


    private final ModelMapper modelMapper;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long booking_id) {
        return null;
    }

    @Override
    public BookingResponse bookNewMovie(BookingDto newBooking) {

        BookingResponse response=new BookingResponse();

       Optional<Movie> movieOptional= movieRepository.findById(newBooking.getMovieId());
       if(!movieOptional.isPresent())
       {
           throw new MovieNotFoundException("movie is not available");
       }

       Optional<Theatre> theatreOptional=theatreRepository.findById(newBooking.getTheaterId());

        Optional<User> userOptional= userRepository.findByUserId(newBooking.getUserId());

       if(!userOptional.isPresent())
       {
           throw new UserNotFoundException("user not available");
       }

       Movie movie=movieOptional.get();

        Optional<Screening> movieScreen=movie.getScreenings().stream().filter(j->j.getTheaterId().equalsIgnoreCase(newBooking.getTheaterId())).findAny();

        if(movieScreen.isPresent())
        {
            Screening screening= movieScreen.get();

            for(ShowDetails showDetails: screening.getShow())
            {
                if(showDetails.getDate().compareTo(newBooking.getShowDate())==0) {
                    for(Timings t:showDetails.getTimes())
                    {
                        if(t.getNoOfSeat()>= newBooking.getBookedSeats().getNoOfSeat())
                        {
                            response.setShowTime(t.getShowTime());
                            int r=newBooking.getBookedSeats().getNoOfSeat()-t.getNoOfSeat();
                            t.setNoOfSeat(r);

                        }
                    }
                }
            }

            movieRepository.save(movie);

            Optional<Auditorium> auditoriumOptional=theatreOptional.get().getAuditorium().stream().filter(i->i.getScreenId().equalsIgnoreCase(newBooking.getScreeningId())).findAny();

            Booking booking=modelMapper.map(newBooking,Booking.class);
            booking.setBookId(booking.getBookId());
            booking.setStatus("Initiated");
            bookingRepository.save(booking);



            response.setMovieName(movie.getMovieName());
            response.setBookId(booking.getBookId());
            response.setBookedSeats(newBooking.getBookedSeats());
            response.setTheaterName(theatreOptional.get().getName());
            response.setShowDate(newBooking.getShowDate());
            response.setActive(true);
            response.setBookingTime(LocalTime.now());
            response.setScreenName(auditoriumOptional.get().getAuditoriumName());


            return response;




      /*      Timings timings=screening.getShow().stream()
                    .filter(i->i.getDate().isEqual(newBooking.getShowDate()))
                    .findAny().orElseThrow()
                    .getTimes().stream().filter(j->j.getShowTime().equals(newBooking.getShowTime()))
                    .map(k->k.getNoOfSeat()>= newBooking.getBookedSeats().getNoOfSeat()).findAny()
                    .orElseThrow();*/
        }


        return null;
    }

    @Override
    public Booking updateBooking(Booking updatedBooking, Long booking_id) {
        return null;
    }

    @Override
    public void deleteBookingById(Long booking_id) {

    }
}

