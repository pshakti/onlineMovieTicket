package com.bookmyshow.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@NoArgsConstructor
@Document("user")
public class User {

    @Id
    private String userId;

    private String userName;

    private String password;

    private String email;
}
