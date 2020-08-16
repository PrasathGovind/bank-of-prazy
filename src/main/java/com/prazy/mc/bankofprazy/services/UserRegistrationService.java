package com.prazy.mc.bankofprazy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prazy.mc.bankofprazy.configs.DynamoDBConfig;

@Service
public class UserRegistrationService {
	
	@Autowired
	DynamoDBConfig dynamoDBConfig;
	
	
	public void registerUser() {
		
		System.out.println("dynamoDBConfig : "+dynamoDBConfig);
		
	}
	

}
