package com.bookmyshow.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class ShowDetails {

   // private String auditoriumName;
   private String screeningId;
    private LocalDate date;

    private Set<Timings> times;
}
