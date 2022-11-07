package com.project1.models;

public class Ticket /*implements Serializable*/ {
	
	//private static final long serialVersionUID = 1L;
	
	private int ticketId;
	private double amount;
	private String ticketCreator;
	private String ticketApprover;
	private String description;
	private TicketStatus status;
	private int employeeId;
	
	
	public Ticket() {
		super();
	}
	
	


	public Ticket(int ticketId, double amount, String ticketCreator, String ticketApprover, String description,
			TicketStatus status, int employeeId) {
		super();
		this.ticketId = ticketId;
		this.amount = amount;
		this.ticketCreator = ticketCreator;
		this.ticketApprover = ticketApprover;
		this.description = description;
		this.status = status;
		this.employeeId = employeeId;
	}




	public int getTicketId() {
		return ticketId;
	}




	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}




	public double getAmount() {
		return amount;
	}




	public void setAmount(double amount) {
		this.amount = amount;
	}




	public String getTicketCreator() {
		return ticketCreator;
	}




	public void setTicketCreator(String ticketCreator) {
		this.ticketCreator = ticketCreator;
	}




	public String getTicketApprover() {
		return ticketApprover;
	}




	public void setTicketApprover(String ticketApprover) {
		this.ticketApprover = ticketApprover;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public TicketStatus getStatus() {
		return status;
	}




	public void setStatus(TicketStatus status) {
		this.status = status;
	}




	public int getEmployeeId() {
		return employeeId;
	}




	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}




	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", amount=" + amount + ", ticketCreator=" + ticketCreator
				+ ", ticketApprover=" + ticketApprover + ", description=" + description + ", status=" + status
				+ ", employeeId=" + employeeId + "]";
	}
	
	
}
