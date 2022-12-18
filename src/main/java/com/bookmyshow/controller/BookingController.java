package com.bookmyshow.controller;

import com.bookmyshow.entity.Booking;
import com.bookmyshow.model.BookingDto;
import com.bookmyshow.model.BookingResponse;
import com.bookmyshow.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class BookingController {
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping("/bookings")
    public ResponseEntity bookMovie(@RequestBody BookingDto bookingDto)
    {
        BookingResponse response=bookingService.bookNewMovie(bookingDto);
        return ResponseEntity.created(URI.create("")).body(response);
    }
}
