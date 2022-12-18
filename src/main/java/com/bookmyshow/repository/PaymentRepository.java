package com.bookmyshow.repository;

import com.bookmyshow.entity.Payment;
import com.bookmyshow.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
}
