package com.project1.services;

import java.util.List;

import com.project1.dao.UserDao;
import com.project1.exceptions.UserAlreadyExistsException;
import com.project1.exceptions.UserDoesNotExistException;
import com.project1.models.User;
import com.project1.utils.LoggingUtil;

public class UserService {
	
	private UserDao userDao;
	
	//Dependency injection, it allows us to change components of the same 'type' easily
	
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void registerUser(User u) {
		try{
			userDao.registerUser(u);
			
			LoggingUtil.getLogger().warn("User: " + u + "was registered");
			//
		} catch(Exception e) {
			LoggingUtil.getLogger().warn("User with email" + u.getEmail() + "tried to register a second time");
			throw new UserAlreadyExistsException();
		} 
	
	}

	public User login(String email) {
		//TODO figure out real logic for project
		User u = userDao.getUserByEmail(email);
		
		if(u == null) {
			LoggingUtil.getLogger().warn("User with email" + email + " had a failed login attempt");
			 
			throw new UserDoesNotExistException();
		}
		
		LoggingUtil.getLogger().info("User " + email + " logged in");
		return u;
	}
	
	public List<User> getAllRegistered(){
		return userDao.getAllUsers();
	}
	
	public void removeUser(String email) {
		userDao.deleteUser(email);
		LoggingUtil.getLogger().info("User " + email + " was removed from the system");
	}
	
	
	public void updateUser(User u) {
		userDao.updateUser(u);
		LoggingUtil.getLogger().info("User " + u.getUserId() + " was updated");
	}
	
	

}
