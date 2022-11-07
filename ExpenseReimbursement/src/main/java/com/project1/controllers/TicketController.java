package com.project1.controllers;


import java.util.LinkedHashMap;

import com.project1.models.Ticket;
import com.project1.services.TicketService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.http.Handler;

public class TicketController {
	
	private TicketService tServ;
	private ObjectMapper om;
	
	
	public TicketController(TicketService tServ) {
		this.tServ = tServ;
		om = new ObjectMapper();
	}
	
	public Handler handleCreate = (context) -> {
		
		Ticket t = om.readValue(context.body(), Ticket.class);
		
		tServ.createTicket(t);
		
		context.status(201);
		context.result("New ticket created");
		
		
	};
	
	public Handler handleRead = (context) -> {
		context.status(200);
		context.result(om.writeValueAsString(tServ.getAllTickets()));
	};
	
	public Handler handleUpdate = (context) -> {
		Ticket t = om.readValue(context.body(), Ticket.class);
		tServ.updateTicket(t);
		context.status(200);
		context.result("Ticket was updated");
	};
	
	
	public Handler handleDelete = (context) -> {
		LinkedHashMap<String, Integer> body = om.readValue(context.body(), LinkedHashMap.class);
		
		tServ.deleteTicket(body.get("ticketId"));
		
		context.status(200);
		context.result("Ticket was removed");
		
		
	};

}
