package com.msvc.boot.msauthsvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msvc.boot.msauthsvc.dto.AuthRequest;
import com.msvc.boot.msauthsvc.dto.AuthResponse;
import com.msvc.boot.msauthsvc.entity.AuthUser;
import com.msvc.boot.msauthsvc.repository.AuthUserRepository;
import com.msvc.boot.msauthsvc.utils.JWTUtils;

import java.util.UUID; 

@Service
@Transactional
public class AuthUserService {
	
	private static Logger logger = LoggerFactory.getLogger(AuthUserService.class);

	@Autowired
	private AuthUserRepository authRepo;
	
	@Autowired
	private JWTUtils jwtUtil;

	
	public AuthResponse register(AuthRequest authRequest) {
		
		AuthResponse authResponse = new AuthResponse();
		AuthUser usr = createUser(authRequest);
		authResponse.setRefreshToken(usr.getRefreshToken());
		authResponse.setAuthToken(jwtUtil.generate(authRequest, "AUTHTOKEN"));
		logger.info("######### After AuthResponse ####### {}",authResponse );
		return authResponse;
				
	}
	
	public AuthUser createUser(AuthRequest authRequest) {
     
		logger.info("######### About to create AuthUser #######");
		
		UUID uuid = UUID.randomUUID();
		AuthUser user = new AuthUser();
		user = convertDTO(authRequest,user);
		user.setRefreshToken(uuid.toString());
		
		user = authRepo.save(user);
		logger.info("######### After creating AuthUser ####### {}",user );
		return user;
		
		
	}
	
	
	private AuthUser convertDTO(AuthRequest authRequest,AuthUser user) {
		
		user.setUserId(authRequest.getUserId());
		user.setPassword(authRequest.getPassword());
		user.setFirstName(authRequest.getFirstName());
		user.setLastName(authRequest.getLastName());
		user.setRole(authRequest.getRole());
		user.setEmail(authRequest.getEmail());
				
		return user;
		
	}
	

}
