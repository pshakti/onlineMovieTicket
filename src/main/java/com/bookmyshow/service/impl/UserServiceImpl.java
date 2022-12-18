package com.bookmyshow.service.impl;

import com.bookmyshow.entity.User;
import com.bookmyshow.model.UserDto;
import com.bookmyshow.repository.UserRepository;
import com.bookmyshow.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.naming.ServiceUnavailableException;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User registerUser(UserDto newUser) throws ServiceUnavailableException {
        User theatreObj=modelMapper.map(newUser,User.class);
        try {
            theatreObj.setUserId(UUID.randomUUID().toString());
            theatreObj= userRepository.save(theatreObj);
        }catch (Exception e)
        {
            log.info("Exception while adding the new user in dataBase , EXCEPTION {}",e.getMessage());
            throw new ServiceUnavailableException();
        }

        return theatreObj;
    }

}
