package com.bookmyshow.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@NoArgsConstructor
@Document("auditorium")
public class Auditorium {

    private String auditoriumName;

    private Integer seatCount;
}
