package com.jwtExample.JWT.generator.demo.service;

import com.jwtExample.JWT.generator.demo.entity.Customer;

public interface CustomerService {
	
	public Customer findByEmail(String username);

}
