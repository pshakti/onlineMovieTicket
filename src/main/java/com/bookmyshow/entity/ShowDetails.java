package com.bookmyshow.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class ShowDetails {

    private String auditoriumName;

    private LocalDate date;

    private Set<Double> times;

    private Boolean isFull;

    private Double price;


}
