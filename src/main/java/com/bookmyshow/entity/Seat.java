package com.bookmyshow.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Getter
@Setter
@Document("seat")
public class Seat {
    @Id
    @Field("_id")
    private String id;

    private Integer seatNumber;

    private Auditorium auditorium;

    private Set<SeatBooked> bookedSeats;
}
