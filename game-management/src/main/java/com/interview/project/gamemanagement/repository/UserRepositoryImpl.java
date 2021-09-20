package com.interview.project.gamemanagement.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.interview.project.gamemanagement.model.User;

@Component
public class UserRepositoryImpl {
	
	@PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;
    
    public User getUserByUserName(String username) {
    	String queryStr = "SELECT u from User u where u.userName = :username";
    	TypedQuery<User> query = entityManager.createQuery(queryStr, User.class);
    	query.setParameter("username", username);
    	List<User> users = query.getResultList();
    	return CollectionUtils.isEmpty(users) ? null : users.get(0); 
    }
}
