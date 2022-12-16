package com.bookmyshow.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@Document("booking")
public class  Booking {
    @Id
    @Field("_id")
    private String id;

    private Screening screening;

    private User user;

    private LocalTime bookingTime;

    private boolean isBooked;

    private boolean isActive;

    private SeatBooked bookedSeats;
}
