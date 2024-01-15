package com.Room.Controller;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Room.Models.Room;
import com.Room.Models.RoomList;
import com.Room.Service.Roomservice;

//mark class as Controller 
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/rooms")
public class RoomController {

	//autowire the RoomService class  
	@Autowired
	Roomservice roomService;

	@GetMapping("/message")
	public String test() {
		return "Hello I am From Microservice2";
	}
	
	//creating post mapping that post the Room detail in the database
		@PostMapping("/addRoom")
	public void addRoom(@RequestBody Room room) {
		 this.roomService.addRoom(room);
	}

		//creating a get mapping that retrieves all the Rooms detail from the database
	@GetMapping("/findAllRoom")
	public RoomList getAllRoom() {

		RoomList list=new RoomList();
		list.setAllRoom(this.roomService.getAllRoom());
		return list;
		
	}

	//creating a get mapping that retrieves the detail of a specific Room
	@GetMapping("/findById/{id}")
	public Optional<Room> getRoom(@PathVariable("id") String id) {

		return this.roomService.getRoom(Long.parseLong(id));
	}


	
	//creating put mapping that updates the Room detail 
	@PutMapping("/update/{id}")
	public void updateRoom(@RequestBody Room room, @PathVariable long id) {
	
     roomService.updateRoom(room,id);
	}

	
	
	
	//creating a delete mapping that deletes a specified department
	@DeleteMapping("/delete/{id}")
	public String deleteRoom(@PathVariable("id") String id) {
		return this.roomService.deleteRoom(Long.parseLong(id));
	}

	//creating a get mapping that retrieves the detail of  Available Rooms
	@GetMapping("/findRoomAvl")
	public RoomList getRoomAvl() {

		return this.roomService.getRoomAvl();
		
	}
	
	
	
	

}