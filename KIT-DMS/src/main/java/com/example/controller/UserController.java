package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDto;
import com.example.response.LoginResponse;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/login")
	public LoginResponse loginUser(@RequestBody UserDto userDto){
		logger.info("UserController  || loginUser");
		return userService.loginUser(userDto);
	}
}
