package com.bookmyshow.service.impl;

import com.bookmyshow.entity.Auditorium;
import com.bookmyshow.entity.Screening;
import com.bookmyshow.entity.Theatre;
import com.bookmyshow.model.AddNewTheaterRequest;
import com.bookmyshow.repository.TheatreRepository;
import com.bookmyshow.service.TheatreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.naming.ServiceUnavailableException;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class TheatreServiceImpl implements TheatreService {
    private final TheatreRepository theatreRepository;

    private final ModelMapper modelMapper;



    @Override
    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    @Override
    public Theatre addNewTheatre(AddNewTheaterRequest newTheatre) throws ServiceUnavailableException {
        Theatre theatreObj=modelMapper.map(newTheatre,Theatre.class);
        try {
            theatreObj.setId(UUID.randomUUID().toString());
            List<Auditorium> screenings= theatreObj.getAuditorium().stream().map(i->
            {
                i.setScreenId(UUID.randomUUID().toString());
                return i;
            }).collect(Collectors.toList());
            theatreObj.setAuditorium(screenings);
            theatreObj=  theatreRepository.save(theatreObj);
        }catch (Exception e)
        {
            log.info("Exception while adding the new theatre in dataBase , EXCEPTION {}",e.getMessage());
            throw new ServiceUnavailableException();
        }
        return theatreObj;
    }
}
