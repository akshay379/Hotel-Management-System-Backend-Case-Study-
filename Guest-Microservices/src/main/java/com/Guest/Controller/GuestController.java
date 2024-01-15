package com.Guest.Controller;





import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Guest.Models.Guest;
import com.Guest.Models.GuestList;
import com.Guest.Service.Guestservice;


//mark class as Controller  
@RestController
@RequestMapping("/Guest")
public class GuestController {
	
	//autowire the GuestService class  
	@Autowired
	Guestservice guestService;

	@GetMapping("/message")
	public String test() {
		return "Hello I am From Microservice3";
	}
	
	
	
	//creating post mapping that post the guest detail in the database
	@PostMapping("/addGuest")
	public Guest addGuest(@RequestBody Guest guest)
	{
		return this.guestService.addGuest(guest);
	}
	
	
	

	
	//creating put mapping that updates the Guest detail   
	@PutMapping("/update/{id}")
	public void updateGuest(@RequestBody Guest guest, @PathVariable long id) {
	
     guestService.updateGuest(guest,id);
	}

	
	
	
	//creating a delete mapping that deletes a specified guest
	@DeleteMapping("/deleteGuest/{id}")
	public String deleteGuestById(@PathVariable("id") String id)
	{
		return this.guestService.deleteGuest(Integer.parseInt(id));
	}
	
	
	
	//creating a get mapping that retrieves the detail of a specific guest
	@GetMapping("getGuest/{id}")
	public Optional<Guest> getGuest(@PathVariable String id)
	{
		return this.guestService.getGuest(Integer.parseInt(id));
	}
	
	

	
	//creating a get mapping that retrieves all the guest detail from the database
	@GetMapping("getAllGuest")
	public GuestList getAllGuest()
	{
		GuestList list=new GuestList();
		list.setAllGuest(this.guestService.getAllGuest());
		return list;
	}

	
}