package com.Room.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.Room.Models.Room;
import com.Room.Repository.RoomMongodbRepos;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class RoomserviceImplTest {
    @Mock
	private RoomMongodbRepos roomMongodbRepo;
	
	private RoomserviceImpl roomServiceImpl;
	

	@BeforeEach
	void setUp() throws Exception {
		this.roomServiceImpl = new RoomserviceImpl(this.roomMongodbRepo);
	
	}

	

	@Test
	void testAddRoom() {
		  Room room = new Room(); 
		  room.setRoomId(101L);
	  room.setRoomCharges(1000); 
	  room.setRoomType("Deluxe");
	  room.setRoomDesc("Deluxe Room"); 
	  room.setRoomAvl(true);
	 roomServiceImpl.addRoom(room);
	  assertNotNull(roomServiceImpl.getRoom(1L)); 
	}

	@Test
	void testGetRoom() {
		roomServiceImpl.getRoom(101L);

		verify(roomMongodbRepo).findById(101L);

	}

//	@Test
//	void testUpdateRoom() {
//
//		  Room room = new Room (101L,1200,"Deluxe","Deluxe Room",false);
//		  roomMongodbRepo.save(room);
//		  room.setRoomCharges(1000);
//		  when( roomMongodbRepo.save(any(Room.class))).thenReturn(room);
//		   assertEquals(room,roomServiceImpl.updateRoom(room));
//	}

	@Test
	void testDeleteRoom() {
		roomServiceImpl.deleteRoom(101L);
		assertThat(roomServiceImpl.getRoom(101L).isEmpty());
	}

	@Test
	void testGetAllRoom() {
		roomServiceImpl.getAllRoom();

		verify(roomMongodbRepo).findAll();

	}

	

	@Test
	void testGetRoomAvl() {
		roomServiceImpl.getRoomAvl();

		verify(roomMongodbRepo).findAvailable();
	}

}
