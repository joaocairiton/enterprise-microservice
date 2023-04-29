package com.cairiton.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cairiton.entities.User;
import com.cairiton.feignClients.UserFeignClient;

@Service
public class UserService implements UserDetailsService{
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	
	@Autowired
	private UserFeignClient userfeignClient;
	
	public User findByEmail(String email) {
		User user = userfeignClient.findByEmail(email).getBody();
		if (user == null) {
			
			logger.error("email not found: " + email);
			
			throw new IllegalArgumentException("Email not found");
		}
		logger.info(" Email found: " + email);
		return user;
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userfeignClient.findByEmail(username).getBody();
		if (user == null) {
			
			logger.error("email not found: " + username);
			throw new UsernameNotFoundException("Email not found");
		}
		logger.info(" Email found: " + username);
		return user;
	}

	
}
