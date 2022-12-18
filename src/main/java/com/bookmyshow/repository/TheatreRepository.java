package com.bookmyshow.repository;

import com.bookmyshow.entity.Theatre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends MongoRepository<Theatre, String> {
}
