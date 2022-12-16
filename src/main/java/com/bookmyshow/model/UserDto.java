package com.bookmyshow.model;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserDto {

    private String userName;

    private String password;

    private String email;
}
