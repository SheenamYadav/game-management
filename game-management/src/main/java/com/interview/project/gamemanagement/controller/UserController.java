package com.interview.project.gamemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.project.gamemanagement.model.AuthenticationRequest;
import com.interview.project.gamemanagement.model.AuthenticationResponse;
import com.interview.project.gamemanagement.model.User;
import com.interview.project.gamemanagement.service.GameUserDetailsService;
import com.interview.project.gamemanagement.service.UserService;
import com.interview.project.gamemanagement.util.JwtUtil;

@RestController
@RequestMapping("/user/")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	GameUserDetailsService gameUserDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@PostMapping("authenticate")
	public ResponseEntity<?> createAuthenticationResponse(@RequestBody AuthenticationRequest request) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect Username or Password.", e);
		}
		
		final UserDetails userDetails = gameUserDetailsService.loadUserByUsername(request.getUserName());
		
		final String jwt = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	
	@PostMapping("register")
	public User registerUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("getUserDetails")
	public User getUser(@RequestHeader Long id) {
		return userService.getUserWithId(id);
	}
	
	@PutMapping("updateUser")
	public Long updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("deleteUser")
	public Long deleteUser(@RequestHeader Long id) {
		return userService.deleteUserWithId(id);
	}
	
	@PostMapping("login/{userName}/{password}")
	public boolean loginUser(@PathVariable(value = "userName") String userName, @PathVariable(value = "password") String password) {
		return true;
	}
	
	@PostMapping("logout/{userName}")
	public boolean logoutUser(@PathVariable(value = "userName") String userName) {
		return true;
	}
}
