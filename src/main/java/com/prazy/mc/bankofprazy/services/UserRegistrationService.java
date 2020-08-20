package com.prazy.mc.bankofprazy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.prazy.mc.bankofprazy.DAO.UserDAO;
import com.prazy.mc.bankofprazy.advisors.APIException;
import com.prazy.mc.bankofprazy.beans.User;
import com.prazy.mc.bankofprazy.constants.ErrorConstants;
import com.prazy.mc.bankofprazy.models.UserDTO;

@Service
public class UserRegistrationService {
	
	@Autowired
	UserDAO userDAO;
		
	public void registerUser(User user){
		
		if(user==null) {
			throw new APIException(ErrorConstants.REQUEST_JSON_VALIDATION_FAILURE, "The request Json is Empty!");
		}
		
		if(user!=null && (user.getMobileNumber()==null || user.getMobileNumber().isEmpty() || user.getEmailId().isEmpty() || user.getEmailId()==null)) {
			throw new APIException(ErrorConstants.USER_REGISTRATION_REJECTED,"Mobile Number are Email Id are mandatory!");
		}
		
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserName(user.getUserName());
		
		userDTO.setEmailId(user.getEmailId());
		
		userDTO.setMobileNumber(user.getMobileNumber());
		
		userDAO.registerUser(userDTO);
		
	}
	

}
