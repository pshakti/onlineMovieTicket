package com.bookmyshow.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
public class SeatBookedDto {

    @Id
    private Long seatBookedId;

    private String noOfSeat;

    private Set<Integer> seatId;

}
