package com.jwtExample.JWT.generator.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jwtExample.JWT.generator.demo.entity.Customer;
import com.jwtExample.JWT.generator.demo.service.CustomerServiceImpl;

public class MyUserDetailsService implements UserDetailsService {
	
	

	private CustomerServiceImpl customerServiceImpl;
	
	@Autowired
	public MyUserDetailsService(CustomerServiceImpl customerServiceImpl ) {
	
		this.customerServiceImpl=customerServiceImpl;
	}
	
	
	
	public MyUserDetailsService() {
		
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Customer findByEmail = customerServiceImpl.findByEmail(username);
		
		return new MyUserDetails(findByEmail);
	}

}
