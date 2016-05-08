package com.ordering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ordering.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

}
