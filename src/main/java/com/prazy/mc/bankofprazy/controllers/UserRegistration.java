package com.prazy.mc.bankofprazy.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegistration {
	
	@PostMapping(path="/register", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> registerUser() {
		
		String msg = "User Registered successfully in Bank of Prazy (BoP), Welcome!";
		
		String jsonResponse = "{ \"msg\":\""+msg+"\" }";
		
		return new ResponseEntity<String>(jsonResponse,HttpStatus.OK);
	}

}
