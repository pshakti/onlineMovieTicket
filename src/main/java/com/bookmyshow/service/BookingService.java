package com.bookmyshow.service;


import com.bookmyshow.entity.Booking;
import com.bookmyshow.model.BookingDto;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();

    Booking getBookingById(Long booking_id);

    Booking bookNewMovie(BookingDto newBooking);

    Booking updateBooking(Booking updatedBooking, Long booking_id);

    void deleteBookingById(Long booking_id);
}

