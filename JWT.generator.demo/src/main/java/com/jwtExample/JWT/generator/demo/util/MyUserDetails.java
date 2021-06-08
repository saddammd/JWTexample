package com.jwtExample.JWT.generator.demo.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jwtExample.JWT.generator.demo.entity.Users;

public class MyUserDetails implements UserDetails {
	
	private List<GrantedAuthority> authorities;
	
	private Users users;
	
	@Autowired
	public MyUserDetails(Users users) {
		
		this.users=users;
	}

	
	
	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}



	public MyUserDetails() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		this.authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(users.getRoles()));
		
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return users.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return users.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
