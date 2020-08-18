package com.prazy.mc.bankofprazy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prazy.mc.bankofprazy.DAO.UserDAO;
import com.prazy.mc.bankofprazy.beans.User;
import com.prazy.mc.bankofprazy.models.UserDTO;

@Service
public class UserRegistrationService {
	
	@Autowired
	UserDAO userRegistrationDAO;
		
	public void registerUser(User user) {
		
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserName(user.getUserName());
		
		userDTO.setEmailId(user.getEmailId());
		
		userDTO.setMobileNumber(user.getMobileNumber());
		
		userRegistrationDAO.registerUser(userDTO);
		
	}
	

}
