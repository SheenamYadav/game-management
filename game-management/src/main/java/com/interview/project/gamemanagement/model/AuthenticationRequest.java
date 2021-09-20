package com.interview.project.gamemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationRequest {
	
	private String userName;
	private String password;

}
