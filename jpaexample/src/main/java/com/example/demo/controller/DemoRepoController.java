package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AdminUser;
import com.example.demo.entity.User;
import com.example.demo.repo.AdminUserRepository;
import com.example.demo.repo.UserRepository;

@RestController
@RequestMapping("/api")
public class DemoRepoController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	private AdminUserRepository adminRepo;
	
	
	
	@GetMapping("/users/name/{userName}")
	public List<User> findUser(@PathVariable("userName") String userName ) {
		return userRepo.findByName(userName);
	}

	
	@GetMapping("/admin/{userName}")
	public AdminUser findAdminUser(@PathVariable("userName") String userName ) {
		return adminRepo.findByUserId(userName);
	}
	
	@PostMapping("/users")
   public User createUser( @RequestBody User newUser) {
		
	User createdUser = userRepo.save(newUser);
	return createdUser;
		
		
   }	
   
}
