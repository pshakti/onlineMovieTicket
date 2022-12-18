package com.bookmyshow.entity;

import com.bookmyshow.model.SeatBookedDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@Document("booking")
public class  Booking {
    @Id
    private String bookId;

    private String movieId;

    private String theaterId;

    private String screeningId;

    private String userId;

    private LocalDate showDate;

    private Double showTime;

    private LocalTime bookingTime;

    private String status;

    private boolean isActive;

    private double amount;
    private SeatBookedDto bookedSeats;
}
