package com.ers.services;

import java.util.List;

import com.ers.dao.EmployeeDao;

import com.ers.exceptions.EmployeeDoesNotExistException;
import com.ers.models.Employee;
import com.ers.utils.LoggingUtil;

public class EmployeeService {
	
	private EmployeeDao employeeDao;
	
	//Dependency injection, it allows us to change components of the same 'type' easily
	
	public EmployeeService(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public void registerEmployee(Employee emp1) {
		
		
		try{
			employeeDao.getEmployeeByEmail(emp1.getEmail());
			
			LoggingUtil.getLogger().warn("User with email" + emp1.getEmail() + "tried registering again");
		} catch(EmployeeDoesNotExistException e) {
			employeeDao.addEmployee(emp1);
			LoggingUtil.getLogger().info("New user registered");
		}
	
	}

	public Employee login(String email) {
		//TODO figure out real logic for project
		Employee emp1 = employeeDao.getEmployeeByEmail(email);
		
		if(emp1 == null) {
			LoggingUtil.getLogger().warn("User with email" + email + " had a failed login attempt");
			//TODO throw an invalid credentials or something
			return null;
		}
		
		LoggingUtil.getLogger().info("User " + email + " logged in");
		return emp1;
	}
	
	public List<Employee> getAllRegistered(){
		return employeeDao.getAllEmployees();
	}

}
