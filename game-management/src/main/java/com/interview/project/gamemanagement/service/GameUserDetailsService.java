package com.interview.project.gamemanagement.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.interview.project.gamemanagement.repository.UserRepository;

@Service
public class GameUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.interview.project.gamemanagement.model.User user = userRepository.getUserByUserName(username);
		if(user==null) throw new UsernameNotFoundException(username);
		return new User(username, user.getPassword(), new ArrayList<>());
	}
}
