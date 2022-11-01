package com.ers.dao;

import java.util.ArrayList;
import java.util.List;

import com.ers.exceptions.EmployeeDoesNotExistException;
import com.ers.models.Employee;

public class EmployeeDaoFile implements EmployeeDao {
	
	private FileIO<List<Employee>> io;
	
	public EmployeeDaoFile() {
		this.io = new FileIO<List<Employee>>("employees.txt");
	}

	@Override
	public void addEmployee(Employee emp1) {
		
		List<Employee> empList = io.readObject();
		if(empList == null) {
			empList = new ArrayList<>();
		}

		empList.add(emp1);
		
		io.writeObject(empList);
	}
	

	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> empList = io.readObject();
		
		if(empList == null) {
			empList = new ArrayList<>();
		}
		
		return empList;
		
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		
		List<Employee> empList = io.readObject();
		
		if(empList == null) {
			empList = new ArrayList<>();
		}

		for(Employee emp1: empList) {
			if(emp1.getEmail().equals(email)) {
				return emp1;
			}
		}
		
		//Instead of returning null, throw a new exception
		throw new EmployeeDoesNotExistException();
		
	}

	@Override
	public void deleteEmployee(String email) {
		
		List<Employee> empList = io.readObject();
		
		if(empList == null) {
			empList = new ArrayList<>();
		}

	
		for(int i=0; i<empList.size(); i++) {
			if(empList.get(i).getEmail().equals(email)) {
				empList.remove(i);
				return;
			}
		}
		
		//Instead of returning null, throw a new exception
		throw new EmployeeDoesNotExistException();
		
	}

	@Override
	public void updateEmployee(Employee emp1) {
		// Consider adding a unique ID that's not going to change
		List<Employee> empList = io.readObject();
		
		if(empList == null) {
			empList = new ArrayList<>();
		}
		
		for(int i=0; i<empList.size(); i++) {
			// We are assuming the email is the unique identifier of this table
			if(empList.get(i).getEmail().equals(emp1.getEmail())) {
				empList.remove(i);
				empList.add(emp1);
				return;
			}
		}
		
		//Instead of returning null, throw a new exception
		throw new EmployeeDoesNotExistException();
		
	}

}
