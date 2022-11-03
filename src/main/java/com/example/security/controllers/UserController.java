package com.example.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.dto.User;
import com.example.security.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	//Get All Users
	@GetMapping("/fetchAllUsers")
	public List<User> getAllUsers() {
		System.out.println("Inside @RestController GetAllUsers");
		return this.userService.getAllUsers();
	}
	
	//Get Single User
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") long id) {
		System.out.println("Inside @RestController getUser");
		return this.userService.getUser(id);
	}
	
	
	//Add User
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		System.out.println("Inside @RestController addUser");
		return this.userService.addUser(user);
	}
	
}
