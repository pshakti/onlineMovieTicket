package com.bookmyshow.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class ScreeningDto {

    private String auditoriumName;

    private LocalDate date;

    private Set<Double> times;

    private Boolean isFull;

    private Double price;

    private String city;

    private String theaterName;

}