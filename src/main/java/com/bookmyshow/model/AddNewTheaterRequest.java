package com.bookmyshow.model;

import lombok.Data;

import java.util.Set;

@Data
public class AddNewTheaterRequest {

    private String name;

    private String city;

    private Set<AuditoriumDto> auditorium;
}
