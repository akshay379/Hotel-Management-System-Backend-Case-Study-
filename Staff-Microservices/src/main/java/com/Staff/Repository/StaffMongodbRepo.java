package com.Staff.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Staff.Models.Staff;


//Repository That extends Mongo Repository
@Repository
public interface  StaffMongodbRepo extends MongoRepository<Staff, Long> {

}
