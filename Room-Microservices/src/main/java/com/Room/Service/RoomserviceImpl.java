package com.Room.Service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Room.Models.Room;
import com.Room.Models.RoomList;
import com.Room.Repository.RoomMongodbRepos;



//defining the business logic
@Service
public class RoomserviceImpl implements Roomservice{
	
	@Autowired
	RoomMongodbRepos  roomMongodbRepo;

	//inserting a specific record 
	public void addRoom(Room room) {
	
		 roomMongodbRepo.insert(room);
	}
		
	//getting a specific record by using the method findById() of  MongoRepository  
	@Override
	public Optional<Room> getRoom(long parseLong) {
		
		return roomMongodbRepo.findById(parseLong);
	}
	
	

	//saving a specific record by using the method save() of  MongoRepository  

	@Override
	public Room updateRoom(Room room,long id) {
		room.setRoomId(id);
			return roomMongodbRepo.save(room);
	}
	
	
	
	//deleting a specific record by using the method deleteById() of MongoRepository  
	@Override
	public String deleteRoom(long parseLong) {
		roomMongodbRepo.deleteById(parseLong);
		return "Room Number "+parseLong+" Deleted";
	}

	
	
	//getting all record by using the method findaAll() of MongoRepository  
	@Override
	public List<Room> getAllRoom() {
		
		return roomMongodbRepo.findAll();
	}
public RoomserviceImpl (RoomMongodbRepos roomMongodbRepo) {
	
	this.roomMongodbRepo=roomMongodbRepo;
}

//getting Available Room record by using the method findavailabe() of MongoRepository  
	@Override
	public RoomList getRoomAvl() {
		
		RoomList list=new RoomList();
		list.setAllRoom(roomMongodbRepo.findAvailable());;
		return list;
	}

}
