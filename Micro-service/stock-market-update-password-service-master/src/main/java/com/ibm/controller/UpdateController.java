package com.ibm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.model.User;

@RestController
public class UpdateController {
	
	@Autowired
	UserServiceProxy userService;
	
	@PostMapping("/updatePassword")
	public User updatePassword(@RequestBody User user, HttpServletRequest request) {
		return userService.updatePassword(user);
	}

}
