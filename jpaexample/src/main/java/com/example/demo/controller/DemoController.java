package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserDAOService;

@RestController
@RequestMapping("/api")
public class DemoController {
	
	@Autowired
	UserDAOService userSvc;
	
	@GetMapping("/users")
	public List<User> findallUsers() {
		return userSvc.findAll();
	} 
	
	@GetMapping("/users/{userId}")
	public User findUser(@PathVariable("userId") Long userId ) {
		return userSvc.find(userId);
	}

}
