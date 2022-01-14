package com.msvc.boot.msauthsvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msvc.boot.msauthsvc.service.AuthUserService;

import com.msvc.boot.msauthsvc.dto.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthServiceController {
	
	private static Logger logger = LoggerFactory.getLogger(AuthServiceController.class);
	
	@Autowired
	private  AuthUserService authService;
	
	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest authRequest) {
		return ResponseEntity.ok(authService.register(authRequest));
		
	}

}
