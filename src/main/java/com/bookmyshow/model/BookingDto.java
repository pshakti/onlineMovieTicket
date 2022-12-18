package com.bookmyshow.model;

import com.bookmyshow.entity.ShowDetails;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingDto {

    private String movieId;

    private String theaterId;

    private String screeningId;

    private String userId;

    private LocalDate showDate;

    private Double showTime;

    private double amount;

    private SeatBookedDto bookedSeats;
}
