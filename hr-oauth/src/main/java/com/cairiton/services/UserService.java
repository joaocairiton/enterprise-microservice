package com.cairiton.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cairiton.entities.User;
import com.cairiton.feignClients.UserFeignClient;

@Service
public class UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	
	@Autowired
	private UserFeignClient feignClient;
	
	public User findByEmail(String email) {
		User user = feignClient.findByEmail(email).getBody();
		if (user == null) {
			
			logger.error("email not found: " + email);
			
			throw new IllegalArgumentException("Email not found");
		}
		logger.info(" Email found: " + email);
		return user;
		
	}

}
