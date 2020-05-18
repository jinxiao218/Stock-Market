package com.ibm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.exception.ResourceNotFoundException;
import com.ibm.exception.UserError;
import com.ibm.model.User;
import com.ibm.repository.UserRepository;
import com.ibm.service.UserService;
import com.ibm.utils.UUIDUtils;

@RestController
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return repository.findAll();
	}
	
	@PostMapping("/createAdmin")
	public User createAdmin(@Valid @RequestBody User user, HttpServletRequest request) {
		User newUser =createUser(user, 0, request);
		userService.register(newUser);
		return newUser;
	}
	
	@PostMapping("/updatePassword")
	public User updatePassword(@RequestBody User user, HttpServletRequest request) {
		return updatePassword(user);
	}
	
	@PostMapping("/signup")
	public User signup(@Valid @RequestBody User user, HttpServletRequest request) {
		User newUser =createUser(user, 1, request);
		userService.register(newUser);		
		return newUser;
	}
	/*
	 * check the user by search code,change the confirmed to 0;
	 */
	@RequestMapping("/checkCode")
	public String checkCode(String code) {
		User user = userService.checkCode(code);
		System.out.println(user);
		// 如果用户不等于null，把用户状态修改confirmed=0
		if (user != null) {
			user.setConfirmed(0);
			System.out.println(user);
			userService.updateUserStatus(user);
		}

		return "login";
	}

	private User createUser(User user, int userType, HttpServletRequest request) {
		repository.findByEmail(user.getEmail()).ifPresent(foundUser -> {throw new UserError("User", "Please choose a different email");});
		repository.findByUsername(user.getUsername()).ifPresent(foundUser -> {throw new UserError("User", "Please choose a different username");});
		//by default the user is deactivated and admin is active
		
		user.setActive(userType==0);
		user.setUserType(userType);
		String key = bCryptPasswordEncoder.encode(user.getPassword());
		String code= UUIDUtils.getUUID();
		user.setPassword(key);
		user.setConfirmed(userType);					
		user.setCode(code);
		User newUser = repository.save(user);
		return newUser;
	}
	
	private User updatePassword(User reqUser) {
		User user = repository.findByUsername(reqUser.getUsername()).orElseThrow(() -> new ResourceNotFoundException("User", "username", reqUser.getUsername()));
		String key = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(key);
		User newUser = repository.save(user);
		return newUser;
	}
}
