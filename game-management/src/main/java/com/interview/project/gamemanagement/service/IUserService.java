package com.interview.project.gamemanagement.service;

import com.interview.project.gamemanagement.model.User;

public interface IUserService {

	User saveUser(User user);

	User getUserWithId(Long id);

	Long updateUser(User user);

	Long deleteUserWithId(Long id);
}
