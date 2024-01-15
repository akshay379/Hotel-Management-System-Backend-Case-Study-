package com.Reservation.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Reservation.Models.Reservation;

//repository that extends MongoRepository  
@Repository
public interface ReservationRepo extends MongoRepository<Reservation, Long> {


	
}
