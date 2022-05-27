package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Long> {
	
	List<User> findByName(String name); 

}
