package com.Reservation.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ReservationDetails")
public class Reservation {
	
@Id
private Long bookingId;
	private Long roomId;
	private String checkin;
	private String checkout;
	private String noOfNight;
	private int numOfGuests;
	private double finalPrice;
	
	
	public Reservation(Long bookingId, Long roomId, String checkin, String checkout, String noOfNight, int numOfGuests,
			double finalPrice) {
		super();
		this.bookingId = bookingId;
		this.roomId = roomId;
		this.checkin = checkin;
		this.checkout = checkout;
		this.noOfNight = noOfNight;
		this.numOfGuests = numOfGuests;
		this.finalPrice = finalPrice;
	}
	public String getNoOfNight() {
		return noOfNight;
	}
	public void setNoOfNight(String noOfNight) {
		this.noOfNight = noOfNight;
	}
	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public int getNumOfGuests() {
		return numOfGuests;
	}
	public void setNumOfGuests(int numOfGuests) {
		this.numOfGuests = numOfGuests;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	
	public Reservation() {
		super();
		
	}
	
}
