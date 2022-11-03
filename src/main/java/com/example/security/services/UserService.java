package com.example.security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.security.dto.User;

@Service
public class UserService {
	
	List<User> userList = new ArrayList<>();

	public UserService() {
		userList.add(new User(1,"kiran","password"));
		userList.add(new User(2,"mahesh","pass"));
		userList.add(new User(3,"ravi","p"));
	}
	
	//Get All USers
	public List<User> getAllUsers(){
		System.out.println("Inside Service Class getAllUSers");
		return this.userList;
	}
	
	//Get Single USer
	public User getUser(long id) {
		System.out.println("Inside Service Class getUser");
		return this.userList.stream().filter((user)-> user.getId()==id ).findAny().orElse(null);
	}
	
	//Adding User
	public User addUser(User user) {
		System.out.println("Inside Service Class addUser");
		this.userList.add(user);
		return user;
	}
	
	

}
