package com.bookmyshow.repository;

import com.bookmyshow.entity.Seat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends MongoRepository<Seat, Long> {
}
