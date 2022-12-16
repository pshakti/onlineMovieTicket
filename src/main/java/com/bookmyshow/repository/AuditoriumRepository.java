package com.bookmyshow.repository;

import com.bookmyshow.entity.Auditorium;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends MongoRepository<Auditorium, Long> {
}
