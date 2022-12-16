package com.bookmyshow.service.impl;

import com.bookmyshow.entity.Booking;
import com.bookmyshow.model.BookingDto;
import com.bookmyshow.repository.BookingRepository;
import com.bookmyshow.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;

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
    public Booking bookNewMovie(BookingDto newBooking) {
        Booking booking=modelMapper.map(newBooking,Booking.class);
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

