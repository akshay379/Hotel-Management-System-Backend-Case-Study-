package com.Room.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.Room.Models.Room;



//Repository that extends MongoRepository
@Repository
public interface RoomMongodbRepos extends MongoRepository<Room, Long>  {
	
	//to specify a custom query
	@Query("{roomAvl:true}")
	List<Room>findAvailable();

	
	
	
	

}
