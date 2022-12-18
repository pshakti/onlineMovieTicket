package com.bookmyshow.service;

import com.bookmyshow.entity.Theatre;
import com.bookmyshow.model.AddNewTheaterRequest;

import javax.naming.ServiceUnavailableException;
import java.util.List;

public interface TheatreService {
    List<Theatre> getAllTheatres();
    Theatre addNewTheatre(AddNewTheaterRequest newTheatre) throws ServiceUnavailableException;
}
