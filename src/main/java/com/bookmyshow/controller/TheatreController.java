package com.bookmyshow.controller;

import com.bookmyshow.entity.Theatre;
import com.bookmyshow.model.AddNewTheaterRequest;
import com.bookmyshow.service.TheatreService;
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
public class TheatreController {
    private TheatreService theatreService;

    @Autowired
    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @GetMapping("/theatres")
    public List<Theatre> getAllTheatres() {
        return theatreService.getAllTheatres();
    }

    @PostMapping("/theatre")
    public ResponseEntity addTheatres(@RequestBody AddNewTheaterRequest addNewTheaterRequest) throws ServiceUnavailableException {
            theatreService.addNewTheatre(addNewTheaterRequest);
        return ResponseEntity.created(URI.create("")).body("New theater has been added successfully");
    }
}
