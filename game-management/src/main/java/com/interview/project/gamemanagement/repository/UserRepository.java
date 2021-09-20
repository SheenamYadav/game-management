package com.interview.project.gamemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.project.gamemanagement.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User getUserByUserName(String userName);
}
