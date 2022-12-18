package com.bookmyshow.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Data
public class Auditorium {
    private String screenId;

    private String auditoriumName;

    private Integer seatCount;
}
