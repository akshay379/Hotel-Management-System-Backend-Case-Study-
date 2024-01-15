package com.Guest.Service;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Guest.Models.Guest;
import com.Guest.Repository.GuestRepo;


@Service
public class GuestserviceImpl implements Guestservice {
	
	@Autowired
	GuestRepo guestRepo;

	public GuestserviceImpl(GuestRepo repo) {
		this.guestRepo= repo;
	}
	
	
	//inserting a specific record 
	@Override
	public Guest addGuest(Guest guest) {
		return guestRepo.insert(guest);
	}
	

	
	//saving a specific record by using the method save() of  MongoRepository  
	@Override
	public Guest updateGuest(Guest guest,long id) {
		guest.setGuestId(id);
			return guestRepo.save(guest);
	}
	
	
	
	
	//deleting a specific record by using the method deleteById() of MongoRepository  
	@Override
	public String deleteGuest(int id) {
		guestRepo.deleteById(id);
		return "Deleted Guest Id: "+id;
	}
	
	
	
	//getting a specific record by using the method findById() of  MongoRepository  
	@Override
	public Optional<Guest> getGuest(int id) {
		return guestRepo.findById(id);
	}
	
	
	
	//getting all record by using the method findaAll() of MongoRepository  

	@Override
	public List<Guest> getAllGuest() {
		return guestRepo.findAll();
	}


}
