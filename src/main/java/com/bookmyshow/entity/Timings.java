package com.bookmyshow.entity;

import lombok.Data;

@Data
public class Timings {
   // private String timingsId;

    private Double showTime;

    private Boolean isFull;

    private Double price;

    private int noOfSeat;
}
