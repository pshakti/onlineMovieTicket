package com.bookmyshow.repository;

import com.bookmyshow.entity.Screening;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepository extends MongoRepository<Screening, Long> {}
