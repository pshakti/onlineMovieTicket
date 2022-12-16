package com.bookmyshow.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Data
@NoArgsConstructor
@Document("seat_booked")
public class SeatBooked {

    @Id
    @Field("_id")
    private String seatBookedId;

    private String noOfSeat;

    private Set<Integer> seatId;

}
