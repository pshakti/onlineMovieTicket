package com.bookmyshow.repository;

import com.bookmyshow.entity.SeatBooked;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatBookedRepository extends MongoRepository<SeatBooked, Long> {
}
