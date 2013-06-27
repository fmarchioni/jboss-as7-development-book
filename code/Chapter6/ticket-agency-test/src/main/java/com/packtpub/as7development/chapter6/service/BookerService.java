package com.packtpub.as7development.chapter6.service;





import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import java.util.logging.Logger;


import com.packtpub.as7development.chapter6.model.Seat;
import com.packtpub.as7development.chapter6.service.TicketService;



@Named
@ConversationScoped
public class BookerService implements Serializable {
	@Inject
	private Logger logger;

	int money;
	@Inject TicketService ticketService;
	
	 

	@PostConstruct
	public void createCustomer() {
		this.money=100;

	}



	public void bookSeat(Long seatId, int price)   {
		FacesContext fc = FacesContext.getCurrentInstance(); 

		if (price  > money) {

			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Not enough Money!", "Registration successful");
			fc.addMessage(null, m);		  
			return;
		}
		logger.info("Booking seat "+seatId);
		ticketService.bookSeat(seatId);
		money = money - price;
        
		//jmsService.sendMessage("Booking seat "+seatId);
				 
		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
		if (fc != null)
		fc.addMessage(null, m);	
		logger.info("Seat booked.");




	}
	public int getMoney() {
		return money;
	}




}
