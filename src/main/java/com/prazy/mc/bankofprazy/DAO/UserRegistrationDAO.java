package com.prazy.mc.bankofprazy.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.prazy.mc.bankofprazy.configs.DynamoDBConfig;
import com.prazy.mc.bankofprazy.models.UserDTO;

@Repository
public class UserRegistrationDAO {
	
	@Autowired
	DynamoDBConfig dynamoDBConfig;
	
	@Autowired
	DynamoDBMapper dynamoDBMapper;
	
	
	public void registerUser(UserDTO userDTO) {
		
		dynamoDBMapper.save(userDTO);
		
		System.out.println("dynamoDBConfig : "+dynamoDBConfig);
		
	}
	

}
