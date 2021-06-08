package com.jwtExample.JWT.generator.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Customer_Register_Controller {

	@GetMapping("/register")
	public String register() {
		return "register new user";
	}
}
