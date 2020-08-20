package com.prazy.mc.bankofprazy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prazy.mc.bankofprazy.advisors.APIException;
import com.prazy.mc.bankofprazy.beans.User;
import com.prazy.mc.bankofprazy.services.UserRegistrationService;

@RestController
public class UserRegistration {
	
	@Autowired
	UserRegistrationService userRegistrationService;
	
	@PostMapping(path="/register", consumes="application/json; charset=UTF-8", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> registerUser(@RequestBody User user) throws APIException {
		
		userRegistrationService.registerUser(user);
		
		String msg = "User Registration initiated successfully!";
		
		String jsonResponse = "{ \"msg\":\""+msg+"\" }";
		
		return new ResponseEntity<String>(jsonResponse,HttpStatus.OK);
	}

}
