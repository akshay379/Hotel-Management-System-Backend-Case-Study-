package com.Owner.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Owner.Models.OwnerInfo;

public interface OwnerRepo extends MongoRepository<OwnerInfo , String> {
	
	

	OwnerInfo findByemail(String email);

}
