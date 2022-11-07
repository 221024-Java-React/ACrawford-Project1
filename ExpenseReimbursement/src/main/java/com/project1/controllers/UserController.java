package com.project1.controllers;

import io.javalin.http.Handler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.project1.models.User;
import com.project1.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserController {
	
	private UserService uServ;
	
	//Objectmapper will be used to transform our java object from json and vice versa
	private ObjectMapper objectMapper;
	
	public UserController(UserService uServ) {
		this.uServ = uServ;
		objectMapper = new ObjectMapper();
	}
	
	public Handler handleRegister = (context) -> {
		//
		
		User u = objectMapper.readValue(context.body(), User.class);
		
		uServ.registerUser(u);
		
		//Set our status code to OK
		context.status(201);
		context.result(objectMapper.writeValueAsString(u));
		
	};
	
	public Handler handleGetAll = (context) -> {
		List<User> uList = uServ.getAllRegistered();
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(uList));
	};
	
	public Handler handleLogin = (context) -> {
		Map<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		
		User loggedIn = uServ.login(body.get("email"));
		
		context.status(200);
		context.result(objectMapper.writeValueAsString(loggedIn));
	};
	
	public Handler handleDelete = (context) -> {
		Map<String, String> body = objectMapper.readValue(context.body(), LinkedHashMap.class);
		
		uServ.removeUser(body.get("email"));
		
		context.status(200);
		context.result("Person was removed");
	};
	
	public Handler handleUpdate = (context) -> {
		User u = objectMapper.readValue(context.body(), User.class);
		
		uServ.updateUser(u);
		
		context.status(200);
		context.result("User's information was update");
		
	};

}


