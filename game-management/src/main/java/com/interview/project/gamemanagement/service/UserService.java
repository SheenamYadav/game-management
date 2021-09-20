package com.interview.project.gamemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.project.gamemanagement.model.User;
import com.interview.project.gamemanagement.repository.UserRepository;

@Service
public class UserService implements IUserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserWithId(Long id) {
		return userRepository.getById(id);
	}

	@Override
	public Long updateUser(User user) {
		User userFromDb = userRepository.getUserByUserName(user.getUserName());
		if(userFromDb!=null) {
			User result = userRepository.save(user);
			return result.getUserId();
		}
		return null;
	}

	@Override
	public Long deleteUserWithId(Long id) {
		User user = userRepository.getById(id);
		if(user!=null) {
			userRepository.delete(user);
			return user.getUserId();
		}
		return null;
	}
}
