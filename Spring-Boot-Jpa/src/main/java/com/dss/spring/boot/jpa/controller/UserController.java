package com.dss.spring.boot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dss.spring.boot.jpa.domain.UserDomain;
import com.dss.spring.boot.jpa.dto.UserDTO;
import com.dss.spring.boot.jpa.service.UserService;

@Controller
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public UserDTO create(@RequestBody UserDTO user) {
		return userService.create(user);
	}
	
	@GetMapping("getBy/{userId}")
	public UserDTO getById(@PathVariable Long userId) {
		return userService.getById(userId);
	}

}
