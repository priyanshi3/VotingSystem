package com.project.voting.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.voting.entity.Login;

@Repository
public class LoginDAO {

	private EntityManager entityManager;
	
	@Autowired
	public LoginDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	public List<Login> getUsers() {
		Session currentSession = entityManager.unwrap(Session.class);
		TypedQuery<Login> theQuery = currentSession.createQuery("from Login", Login.class);
		List<Login> users = theQuery.getResultList();
		currentSession.close();
		return users;
	}
	
	@Transactional
	public void validateUser(final Login user) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(user);
		currentSession.close();
	}
}
