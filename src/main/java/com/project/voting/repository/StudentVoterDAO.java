package com.project.voting.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.voting.entity.StudentVoter;

@Repository
public class StudentVoterDAO {

	private EntityManager entityManager;
	
	@Autowired
	public StudentVoterDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	public List<StudentVoter> getVoters() {
		Session currentSession = entityManager.unwrap(Session.class);
		TypedQuery<StudentVoter> theQuery = currentSession.createQuery("from StudentVoter", StudentVoter.class);
		List<StudentVoter> voters = theQuery.getResultList();
		currentSession.close();
		return voters;
	}
	
	public StudentVoter getVoter(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		StudentVoter voter = currentSession.get(StudentVoter.class, id);
		currentSession.close();
		return voter;
	}
	
	@Transactional
	public void updateVoter(final StudentVoter voter) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(voter);
		currentSession.close();
	}
	
}
