package com.bookmyshow.service;


import com.bookmyshow.entity.Auditorium;
import com.bookmyshow.model.AuditoriumDto;

import java.util.List;
public interface AuditoriumService {
   List<Auditorium> getAllAuditoriums();
}
