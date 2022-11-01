package com.ers.controllers;

import java.util.logging.Handler;

import com.ers.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeController {
	
	private EmployeeService empServ;
	
	//Objectmapper will be used to transform our java object from json and vice versa
	private ObjectMapper objectMapper;
	
	public EmployeeController(EmployeeService empServ) {
		this.empServ = empServ;
		objectMapper = new ObjectMapper();
	}
	
	public Handler handleRegister = (context) -> {
		Employee emp1 = objectMapper.readValue(context.body(), Employee.class);
		
		empServ.registerEmployee(emp1);
		
		//Set our status code to OK
		context.status(201);
		context.result(objectMapper.writeValueAsString(emp1));
		
	};
	
	public Handler handleGetAll = (context) -> {
		List<Employee> empList = empServ.getAllRegistered();
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(empList));
	};
	
	public Handler handleLogin = (context) -> {
		Map<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		
		Employee loggedIn = empServ.login(body.get("email"));
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(loggedIn));
	};

}
