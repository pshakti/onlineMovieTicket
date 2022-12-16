package com.bookmyshow.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@Document("theatre")
public class Theatre {
    @Id
    @Field("_id")
    private String id;

    private String name;

    private String city;

    private List<Auditorium> auditorium;
}
