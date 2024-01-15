package com.Guest.Service;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Guest.Models.Guest;


@Service
public interface Guestservice {

	Guest addGuest(Guest guest);

	Guest updateGuest(Guest guest, long id);

	String deleteGuest(int id);

	Optional<Guest> getGuest(int id);

	List<Guest> getAllGuest();



	

	

}
