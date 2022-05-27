package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
@Transactional
public class UserDAOService {
	
	@Autowired
	@PersistenceContext
	private EntityManager em;
	
	private static Logger logger = LoggerFactory.getLogger(UserDAOService.class);
	
	
	public User saveUser (User user) {
		
		logger.info("About to save in DB {} ", user.toString());
		
		em.persist(user);
		
		logger.info("After save in DB {} ", user.toString());
		
		return user;
		
	}
	
	public User find(Long id) {
		
		User user = em.find(User.class, id);
		return user;
		
	}
	
public List<User> findAll() {
		
	@SuppressWarnings("unchecked")
	List<User> users = em.createQuery("from User").getResultList();
		return users;
		
	}
	
public User update(User user) {
		
		 user = em.merge(user);
		return user;
		
	}

}
