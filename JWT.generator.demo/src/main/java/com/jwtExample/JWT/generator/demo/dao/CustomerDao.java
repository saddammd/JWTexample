package com.jwtExample.JWT.generator.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwtExample.JWT.generator.demo.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	public Customer findByEmail(String username);

}
