package com.bookmyshow.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Data
@NoArgsConstructor
@Document("movie")
public class Movie {

    @Id
    @Field("_id")
    private String movieId;
    private String movieName;
    private String genre;
    private Integer duration;
    private Set<Screening> screenings;

}
