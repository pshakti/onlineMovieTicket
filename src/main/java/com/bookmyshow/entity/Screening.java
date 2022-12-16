package com.bookmyshow.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Screening {
    private String theaterName;
    private String city;
    private List<ShowDetails> show;
}
