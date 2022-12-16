package com.bookmyshow.model;

import com.bookmyshow.entity.Screening;
import lombok.Data;

import java.util.Set;

@Data
public class MovieDto {

    private String movieName;
    private String genre;
    private Integer duration;
    private Set<Screening> screenings;
}
