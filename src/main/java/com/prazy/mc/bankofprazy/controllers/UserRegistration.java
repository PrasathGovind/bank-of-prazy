package com.prazy.mc.bankofprazy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prazy.mc.bankofprazy.services.UserRegistrationService;

@RestController
public class UserRegistration {
	
	@Autowired
	UserRegistrationService userRegistrationService;
	
	@PostMapping(path="/register", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> registerUser() {
		
		userRegistrationService.registerUser();
		
		String msg = "User Registered successfully in Bank of Prazy (BoP), Welcome!";
		
		String jsonResponse = "{ \"msg\":\""+msg+"\" }";
		
		return new ResponseEntity<String>(jsonResponse,HttpStatus.OK);
	}

}
