package com.Room.Service;

import java.util.List;
import java.util.Optional;

import com.Room.Models.Room;
import com.Room.Models.RoomList;






public interface Roomservice {

	public void addRoom(Room room);

	

	public Optional<Room> getRoom(long parseLong);

	public Room updateRoom(Room room, long id);

	public String deleteRoom(long parseLong);

	public List<Room> getAllRoom();


	public RoomList getRoomAvl();


	
}