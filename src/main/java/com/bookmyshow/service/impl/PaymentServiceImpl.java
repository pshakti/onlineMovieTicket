package com.bookmyshow.service.impl;

import com.bookmyshow.entity.Booking;
import com.bookmyshow.entity.Payment;
import com.bookmyshow.entity.User;
import com.bookmyshow.exception.BookingNotFoundException;
import com.bookmyshow.model.PaymentDto;
import com.bookmyshow.model.UserDto;
import com.bookmyshow.repository.BookingRepository;
import com.bookmyshow.repository.PaymentRepository;
import com.bookmyshow.repository.UserRepository;
import com.bookmyshow.service.PaymentService;
import com.bookmyshow.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.naming.ServiceUnavailableException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final UserRepository userRepository;
    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;

    private final ModelMapper modelMapper;


    @Override
    public Payment pay(PaymentDto paymentDto) throws ServiceUnavailableException {
        Payment theatreObj=modelMapper.map(paymentDto,Payment.class);
        try {

           Optional<Booking> booking= bookingRepository.findById(paymentDto.getBookId());
            Booking book=booking.get();

           if(!booking.isPresent())
           {
               throw new BookingNotFoundException("Booking not found");
           }
           if(booking.get().getAmount()!= paymentDto.getAmount())
           {
               throw new BookingNotFoundException("Booking not found");
           }
            theatreObj.setPaymentId(UUID.randomUUID().toString());
            book.setStatus("Booked");
            bookingRepository.save(book);
            theatreObj= paymentRepository.save(theatreObj);
        }catch (Exception e)
        {
            log.info("Exception while adding the new user in dataBase , EXCEPTION {}",e.getMessage());
            throw new ServiceUnavailableException();
        }

        return theatreObj;
    }

}
