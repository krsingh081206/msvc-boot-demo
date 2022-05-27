package com.example.demo.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.AdminUser;
import com.example.demo.repo.AdminUserRepository;

@Component
public class AdminUserDemoRunner implements CommandLineRunner{
	
	@Autowired
	private AdminUserRepository adminRepo;

	private static Logger logger = LoggerFactory.getLogger(AdminUserDemoRunner.class);
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	     AdminUser cuser = adminRepo.findByUserId("admin");
	     
	     logger.info("############## User {}" , cuser);
		
	}

}
