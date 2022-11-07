package com.project1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project1.models.Ticket;
import com.project1.models.TicketStatus;
import com.project1.models.User;
import com.project1.utils.JDBCConnectionUtil;

public class TicketDaoJDBC implements TicketDao {
	
	private JDBCConnectionUtil conUtil = JDBCConnectionUtil.getInstance();

	@Override
	public List<Ticket> readAllTickets() {
		
		List<Ticket> tList = new ArrayList();
		
		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "SELECT * FROM tickets";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			ResultSet result = prepared.executeQuery();
			
			while(result.next()) {
				Ticket t = new Ticket();
				
				t.setTicketId(result.getInt(1));
				t.setDescription(result.getString(2));
				t.setAmount(result.getDouble(3));
				TicketStatus.valueOf(result.getString("status"));
				// this setStatus refers to the string implementation, not the enum options
				
				
				if(result.getObject(4) == null) {
					t.setManager(null);
				} else {
					
					User u = new User();
					u.setUserId(result.getInt(4));
					t.setManager(u);
				}
				
				tList.add(t);
			}

			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return tList;
	}

	@Override
	public void createTicket(Ticket t) {
		
		//JDBCConnectionUtil conUtil = JDBCConnectionUtil.getInstance();


		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "INSERT INTO tickets(ticketId, description, amount, status}"
					+ "VALUES (?,?,?,?)";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			//Now we need to set these parameters
			prepared.setInt(1, t.getTicketId());
			prepared.setString(2, t.getDescription());
			prepared.setDouble(3, t.getAmount());
			prepared.setString(4, t.getStatus().toString().toUpperCase());
			
			prepared.execute();
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void deleteTicket(int ticketId) {
		// TODO Auto-generated method stub
		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "DELETE FROM tickets WHERE ticketId=?";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			prepared.setInt(1, ticketId);
			
			prepared.execute();
			
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateTicket(Ticket t) {
		
		
		try {
			
			Connection connection = conUtil.getConnection();
			
			String sql = "UPDATE tickets SET description = ?, amount = ?, status =? WHERE ticketId = ?";
			
			PreparedStatement prepared = connection.prepareStatement(sql);
			
			prepared.setString(1, t.getDescription());
			prepared.setDouble(2, t.getAmount());
			prepared.setInt(3, t.getTicketId());
			prepared.setString(4, t.getStatus().toString().toUpperCase());
			/*
			if(t.getManager() == null) {
				prepared.setNull(5, java.sql.Types.INTEGER);
			} else {
				prepared.setInt(5, t.getManager().getUserId());
			}
			*/	
			prepared.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}

