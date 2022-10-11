package com.program.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.program.hroauth.entities.User;
import com.program.hroauth.feignclients.UserFeingClient;

@Service
public class UserService {
	
	
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeingClient userFeingClient;
	
	public User findByEmail(String Email) {
		User user = userFeingClient.findByEmail(Email).getBody();
		if(user == null) {
			logger.error("Email not found" + Email);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("Email found" + Email);
		return user;
	}

}
