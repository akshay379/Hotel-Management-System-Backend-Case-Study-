package com.Receptionist.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.Receptionist.Models.ReceptionistInfo;

public interface ReceptionistRepo extends MongoRepository<ReceptionistInfo, String> {

	ReceptionistInfo findByEmail(String email);
		
	
	
}
