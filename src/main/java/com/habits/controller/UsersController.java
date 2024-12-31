package com.habits.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habits.model.Categorie;
import com.habits.model.HabitResponse;
import com.habits.model.ServiceResponse;
import com.habits.model.User;
import com.habits.model.UserResponse;
import com.habits.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping(path="/users",produces= MediaType.APPLICATION_JSON_VALUE)
@RestController
@Slf4j
public class UsersController {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping("/list")
	public ResponseEntity<ServiceResponse<List<UserResponse>>> getUsers() {
		ResponseEntity<ServiceResponse<List<UserResponse>>> users = service.getUsers();
		return users;
	}
	
	@PostMapping("/create")
	public ResponseEntity<ServiceResponse> createUser(@RequestBody User user) {
	  ResponseEntity<ServiceResponse> createdUser = service.createUser(user);
	  return createdUser;
	} 
	
	
}
