package com.ers.dao;

import java.util.List;

import com.ers.models.Employee;

public interface EmployeeDao {
	
	public void addEmployee(Employee emp1);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeByEmail(String email);
	public void deleteEmployee(String email);
	public void updateEmployee(Employee emp1);
	
}
