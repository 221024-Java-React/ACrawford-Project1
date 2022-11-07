/*
package com.project1.dao;

import java.util.ArrayList;
import java.util.List;

import com.project1.exceptions.UserDoesNotExistException;
import com.project1.models.User;

public class UserDaoFile implements UserDao {
	
	private FileIO<List<User>> io;
	
	public UserDaoFile() {
		this.io = new FileIO<List<User>>("users.txt");
	}

	@Override
	public void addUser(User u) {
		
		List<User> uList = io.readObject();
		if(uList == null) {
			uList = new ArrayList<>();
		}

		uList.add(u);
		
		io.writeObject(uList);
	} 
	

	@Override
	public List<User> getAllUsers() {
		
		List<User> uList = io.readObject();
		
		if(uList == null) {
			uList = new ArrayList<>();
		}
		
		return uList;
		
	}

	@Override
	public User getUserByEmail(String email) {
		
		List<User> uList = io.readObject();
		
		if(uList == null) {
			uList = new ArrayList<>();
		}

		for(User u: uList) {
			if(u.getEmail().equals(email)) {
				return u;
			}
		}
		
		//Instead of returning null, throw a new exception
		throw new UserDoesNotExistException();
		
	}

	@Override
	public void deleteUser(String email) {
		
		List<User> uList = io.readObject();
		
		if(uList == null) {
			uList = new ArrayList<>();
		}

	
		for(int i=0; i<uList.size(); i++) {
			if(uList.get(i).getEmail().equals(email)) {
				uList.remove(i);
				return;
			}
		}
		
		//Instead of returning null, throw a new exception
		throw new UserDoesNotExistException();
		
	}

	@Override
	public void updateUser(User u) {
		// Consider adding a unique ID that's not going to change
		List<User> uList = io.readObject();
		
		if(uList == null) {
			uList = new ArrayList<>();
		}
		
		for(int i=0; i<uList.size(); i++) {
			// We are assuming the email is the unique identifier of this table
			if(uList.get(i).getEmail().equals(u.getEmail())) {
				uList.remove(i);
				uList.add(u);
				return;
			}
		}
		
		//Instead of returning null, throw a new exception
		throw new UserDoesNotExistException();
		
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}

*/
