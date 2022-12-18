package com.bookmyshow.service;


import com.bookmyshow.entity.Booking;
import com.bookmyshow.model.BookingDto;
import com.bookmyshow.model.BookingResponse;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();

    Booking getBookingById(Long booking_id);

    BookingResponse bookNewMovie(BookingDto newBooking);

    Booking updateBooking(Booking updatedBooking, Long booking_id);

    void deleteBookingById(Long booking_id);
}

