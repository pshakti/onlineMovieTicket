package com.bookmyshow.service;


import com.bookmyshow.entity.User;
import com.bookmyshow.model.UserDto;

import javax.naming.ServiceUnavailableException;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();


    void registerUser(UserDto newUser) throws ServiceUnavailableException;


}
