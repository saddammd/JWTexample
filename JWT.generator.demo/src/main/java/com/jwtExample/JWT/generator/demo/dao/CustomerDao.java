package com.jwtExample.JWT.generator.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwtExample.JWT.generator.demo.entity.Users;

@Repository
public interface CustomerDao extends JpaRepository<Users, Integer>{
	
	public Users findByUsername(String username);

}
