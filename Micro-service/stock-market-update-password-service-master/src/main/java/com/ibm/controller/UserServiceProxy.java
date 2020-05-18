package com.ibm.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibm.model.User;

@FeignClient("user-service")
public interface UserServiceProxy {
	@RequestMapping(method = RequestMethod.POST, value = "/updatePassword", consumes = "application/json")
    User updatePassword(User user);
}
