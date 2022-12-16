package com.bookmyshow.controller;

import com.bookmyshow.entity.User;
import com.bookmyshow.model.UserDto;
import com.bookmyshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.ServiceUnavailableException;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/registerUser")
    public ResponseEntity registerUser(@RequestBody UserDto userDto) throws ServiceUnavailableException {
        userService.registerUser(userDto);
        return ResponseEntity.created(URI.create("")).body("New user has been added successfully");
    }
}
