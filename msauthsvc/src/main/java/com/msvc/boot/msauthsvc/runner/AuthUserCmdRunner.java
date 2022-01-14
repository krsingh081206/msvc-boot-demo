package com.msvc.boot.msauthsvc.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.msvc.boot.msauthsvc.dto.AuthRequest;
import com.msvc.boot.msauthsvc.entity.AuthUser;
import com.msvc.boot.msauthsvc.service.AuthUserService;

@Component
public class AuthUserCmdRunner implements CommandLineRunner{

    @Autowired
	private AuthUserService authUserSvc;
    
    private static Logger logger = LoggerFactory.getLogger(AuthUserCmdRunner.class);
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		AuthRequest authReq = new AuthRequest("krsingh01", "Linux#", "Ritesh", "Singh", "dummy1@gmail.com", "admin");
		AuthUser usr  = authUserSvc.createUser(authReq);
		logger.info("Refresh Token {} ", usr.getRefreshToken() );
		
	}

}
