package com.packtpub.as7development.chapter11.model;

import java.io.Serializable;

public class Seat implements Serializable {
	
 
	private int id;
	private String seatName;
	private int price;
    
    private boolean booked;
    
 
	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", seatName=" + seatName + ", price=" + price
				+ ", booked=" + booked + "]";
	}

	public Seat(int id, String seat, int price) {
		this.id = id;
		this.seatName = seat;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
