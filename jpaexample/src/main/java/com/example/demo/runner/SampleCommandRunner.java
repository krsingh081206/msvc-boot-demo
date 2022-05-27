package com.example.demo.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.service.UserDAOService;

@Component
public class SampleCommandRunner implements CommandLineRunner{
	
	@Autowired
	private UserDAOService daosvc;
	
	private static Logger logger = LoggerFactory.getLogger(SampleCommandRunner.class);

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User user1 = new User("HughesSystique","AdminUser","Manager");
		logger.info("Before save id for user {}" , user1.getId());
		
		daosvc.saveUser(user1);
		
		logger.info("After save id for user {}" , user1.getId());
		
		// Find by id
		User user2 = daosvc.find(3l);
		logger.info("After find method call  for user with id {} and details {}" , user2.getId(),user2);
		
		// Updating name for user with id 3;
		
		user2.setName("Ravi");
		daosvc.update(user2);
		
		logger.info("After second save call  for user with id {} and details {}" , user2.getId(),user2);
		
		
	}


}
