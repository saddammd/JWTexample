package com.jwtExample.JWT.generator.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwtExample.JWT.generator.demo.dao.CustomerDao;
import com.jwtExample.JWT.generator.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;
	
	@Autowired
	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao= customerDao;
	}
	
	
	@Override
	public Customer findByEmail(String username) {
		
		Customer cust = customerDao.findByEmail(username);
		
		if(cust!=null) {
			
			return cust;
		}
		
		else {
		
		throw new UsernameNotFoundException("Username not found with the name" +username);
		}
	}

}
