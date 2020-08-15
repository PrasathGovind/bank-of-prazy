package com.prazy.mc.bankofprazy.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegistration {
	
	@PostMapping("/register")
	public String registerUser() {
		
		return "User Registered successfully in Bank of Prazy (BoP)";
	}

}
