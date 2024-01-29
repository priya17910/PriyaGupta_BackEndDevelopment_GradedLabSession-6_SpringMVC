package com.greatlearning.studentmgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.studentmgmt.entity.User;
import com.greatlearning.studentmgmt.repository.UserRepository;
import com.greatlearning.studentmgmt.security.MyUserDetails;

// SERVICE CLASS TO CALL THE FIND BY USERNAME METHOD FROM USER REPOSITORY
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository repository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new MyUserDetails(user);
	}

}
