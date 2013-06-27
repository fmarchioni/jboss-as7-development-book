package com.packtpub.as7development.chapter3.ejb;

import javax.annotation.PostConstruct;



import static javax.ejb.LockType.*;


import javax.ejb.Lock;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.Singleton;
import javax.ejb.Startup;



import org.jboss.logging.Logger;

import com.packtpub.as7development.chapter3.model.Seat;

import java.util.*;


@Singleton
@Startup
 
public class TheatreBox {

	private ArrayList<Seat> seatList;
	private static final Logger logger =
			Logger.getLogger(TheatreBox.class);

	@PostConstruct
	public void setupTheatre(){
		seatList = new ArrayList<Seat>();
		int id = 0;
		for (int i=0;i<5;i++) {
			Seat seat = new Seat(++id, "Stalls",40);
			seatList.add(seat);
		}
		for (int i=0;i<5;i++) {
			Seat seat = new Seat(++id,"Circle",20);
			seatList.add(seat);
		}
		for (int i=0;i<5;i++) {
			Seat seat = new Seat(++id, "Balcony",10);
			seatList.add(seat);
		}
		logger.info("Seat Map constructed.");
	 
	}

	@Lock(READ)  
	public ArrayList<Seat> getSeatList() {

		return seatList;
	}
	@Lock(READ)  
	public int getSeatPrice(int id) {

		return getSeatList().get(id).getPrice();
	}

	@Lock(WRITE)  
	public void buyTicket(int seatId )     {
		Seat seat = getSeatList().get(seatId);

		seat.setBooked(true);


	}

}
