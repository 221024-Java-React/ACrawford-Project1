package com.project1.dao;

import java.util.List;
import com.project1.models.Ticket;

public interface TicketDao {
	
	public List<Ticket> readAllTickets();
	public void createTicket(Ticket t);
	public void deleteTicket(int id);
	public void updateTicket(Ticket t);

}

