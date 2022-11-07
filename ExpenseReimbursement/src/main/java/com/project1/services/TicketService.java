package com.project1.services;

import java.util.List;

import com.project1.dao.TicketDao;
import com.project1.dao.UserDao;
import com.project1.models.Ticket;
import com.project1.utils.LoggingUtil;

public class TicketService {
	
	private TicketDao tDao;
	private UserDao uDao;
	
	public TicketService(TicketDao tDao, UserDao uDao ) {
		this.tDao = tDao;
		this.uDao = uDao;
	}
	
	public List<Ticket> getAllTickets() {
		
		List<Ticket> tList = tDao.readAllTickets();
		
		for(int i = 0; i<tList.size(); i++) {
			Ticket t = tList.get(i);
			if(t.getManager() != null) {
				t.setManager(uDao.getUserById(t.getManager().getUserId()));
				tList.set(i,t);
				
			}
		}
	
		
		return tList;
		
	}

	
	public void createTicket(Ticket t) {
		tDao.createTicket(t);
		LoggingUtil.getLogger().info("New ticket was created: " + t);
	}
	
	public void deleteTicket(int ticketId) {
		tDao.deleteTicket(ticketId);
		LoggingUtil.getLogger().info("Course" + ticketId );
	}
	
	public void updateTicket(Ticket t) {
		tDao.updateTicket(t);
		LoggingUtil.getLogger().info("Course was updated: " + t);
	}
	

}
