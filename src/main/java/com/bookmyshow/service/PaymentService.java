package com.bookmyshow.service;

import com.bookmyshow.entity.Movie;
import com.bookmyshow.entity.Payment;
import com.bookmyshow.model.PaymentDto;

import javax.naming.ServiceUnavailableException;
import java.util.List;

public interface PaymentService {

    Payment pay(PaymentDto paymentDto) throws ServiceUnavailableException;
}
