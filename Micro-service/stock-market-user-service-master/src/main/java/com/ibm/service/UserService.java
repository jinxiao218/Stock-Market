package com.ibm.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ibm.model.User;

public interface UserService extends UserDetailsService{

	User findOne(String userName);
	boolean isConfirmed(String username);
	public void register(User user);
	User checkCode(String code);
	void updateUserStatus(User user);
    User loginUser(User user);
}
