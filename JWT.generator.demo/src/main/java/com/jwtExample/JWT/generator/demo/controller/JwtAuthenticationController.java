package com.jwtExample.JWT.generator.demo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwtExample.JWT.generator.demo.config.JwtTokenUtil;
import com.jwtExample.JWT.generator.demo.entity.JwtRequest;
import com.jwtExample.JWT.generator.demo.entity.JwtResponse;
import com.jwtExample.JWT.generator.demo.util.MyUserDetails;
import com.jwtExample.JWT.generator.demo.util.MyUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	//@Autowired
	//private MyUserDetails myUserDetails;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService myuserDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {

		try {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
			//authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword(), authenticationRequest.getAuthorities());

		}
		catch(Exception e){
			System.out.println("exception caught" +e);
		}
		
		myuserDetailsService.ValidatemyUserDetailsService(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		
		final UserDetails userDetails = myuserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		
				

		
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
		
		
		}

	private void authenticate(String username, String password) throws Exception { 
	//Collection<? extends GrantedAuthority> authority) 
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		//authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password,
					//authority));
			
			
			//if((myUserDetails.getUsername()).toString()  == 
			//(myuserDetailsService.loadUserByUsername(username)).toString()) {}
				
			
			
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
			
		}
	}
}