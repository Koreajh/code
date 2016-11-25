package com.fnsvalue.skillshare.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fnsvalue.skillshare.bo.LoginBO;



public class SecurityService implements UserDetailsService{



	@Autowired LoginBO loginBO;



	@Override

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	

	     com.fnsvalue.skillshare.dto.User user = loginBO.getUsersByID(username);

			

		if (user == null) {

		         throw new UsernameNotFoundException("No user found with username" + user.getUser_id_pk());

		}

			 

	Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();

	     roles.add(new SimpleGrantedAuthority("ROLE_USER"));	

	    UserDetails userDetails = new User(username, user.getUser_pw(), roles);

		

           return userDetails;

	}

}