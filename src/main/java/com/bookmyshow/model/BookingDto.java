package com.bookmyshow.model;

import lombok.Data;

import java.time.LocalTime;

@Data
public class BookingDto {

    private Long movieId;

    private String movieName;

    private ScreeningDto screening;

    private UserDto user;

    private LocalTime bookingTime;

    private boolean isBooked;

    private boolean isActive;

    private SeatBookedDto bookedSeats;
}
