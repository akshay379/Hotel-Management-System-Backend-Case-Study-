package com.Guest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.Guest.Models.Guest;
import com.Guest.Repository.GuestRepo;
import com.Guest.Service.GuestserviceImpl;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class GuestServiceTest {
	
	@Mock
	private GuestRepo repo;
	private GuestserviceImpl service;
	

	@BeforeEach
	void setUp() {
	this.service = new GuestserviceImpl(this.repo);
	}

	//getAlldept
	@Test
	public void getAllGuest(){
		
		service.getAllGuest();
		verify(repo).findAll();
		
	}
	
	
	//getbyId
		@Test
		public void getGuest(){
		
			service.getGuest(1);
			verify(repo).findById(1);
		
		}
		
		//Delete
		@Test
		public void deleteGuest() {
			service.getGuest(1);
			assertThat(service.getGuest(1).isEmpty());
		}
		
		
		//Add
		@Test
		public void addGuest() {
			Guest guest=new Guest();
			guest.setGuestId(5);
			guest.setGuestName("Rahul");
			guest.setGuestContact(9876543210L);
			guest.setGuestEmail("Rahul@gmail.com");
			guest.setGuestGender("male");
			guest.setGuestAddress("vivek nagar");
			assertNotNull(service.getGuest(5));
				
		}
		
//		//update
//		@Test
//		public void updateGuest () {
//			Guest guest=new Guest(5,"Rahul",254356789L,"Rahul@gmail.com","male","ram nagar");
//			
//			repo.save(guest);
//			guest.setGuestContact(666777888999L);;
//		    when(repo.save(any(Guest.class))).thenReturn(guest);
//			assertEquals(guest,service.updateGuest(guest));
//		}
			
	
}