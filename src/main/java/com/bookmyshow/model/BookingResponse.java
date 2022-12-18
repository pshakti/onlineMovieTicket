package com.bookmyshow.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingResponse {

    private String bookId;

    private String movieName;

    private String theaterName;

    private String screenName;

    private LocalDate showDate;

    private Double showTime;

    private LocalTime bookingTime;

    private boolean isBooked;

    private boolean isActive;

    private SeatBookedDto bookedSeats;
}
