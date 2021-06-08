package com.jwtExample.JWT.generator.demo.service;

import com.jwtExample.JWT.generator.demo.entity.Users;

public interface CustomerService {
	
	public Users findByUsername(String username);

}
