package com.jwtExample.JWT.generator.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jwtExample.JWT.generator.demo.entity.JwtRequest;
import com.jwtExample.JWT.generator.demo.entity.Users;
import com.jwtExample.JWT.generator.demo.service.CustomerServiceImpl;

public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@Autowired
	private JwtRequest jwtRequest;

	private String username1;
	private String password2;
	private Users findByEmail;

	public MyUserDetailsService() {

	}

	public void ValidatemyUserDetailsService(String username1, String password2) {
		this.username1 = username1;
		this.password2 = password2;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		this.findByEmail = customerServiceImpl.findByUsername(username);

		if ((this.username1.equals(this.findByEmail.getUsername())) && (this.password2.equals(this.findByEmail.getPassword()))) {

			return new MyUserDetails(this.findByEmail);
		}

		else {
			throw new UsernameNotFoundException("Username Not Found" + username);
		}

	}

}
