package com.bookmyshow.controller;

import com.bookmyshow.entity.Payment;
import com.bookmyshow.entity.User;
import com.bookmyshow.model.PaymentDto;
import com.bookmyshow.model.UserDto;
import com.bookmyshow.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.ServiceUnavailableException;
import java.net.URI;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/pay")
    public ResponseEntity pay(@RequestBody PaymentDto paymentDto) throws ServiceUnavailableException {
        Payment pay= paymentService.pay(paymentDto);
        return ResponseEntity.created(URI.create("")).body(pay);
    }
}
