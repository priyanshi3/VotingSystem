package com.project.voting.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.voting.entity.Candidate;

@Repository
public class CandidateDAO {

	private EntityManager entityManager;
		
	@Autowired
	public CandidateDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	public Candidate getCandidate(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Candidate candidate = currentSession.get(Candidate.class, id);
		currentSession.close();
		return candidate;
	}

	public List<Candidate> getCandidates() {
		Session currentSession = entityManager.unwrap(Session.class);
		TypedQuery<Candidate> theQuery = currentSession.createQuery("from Candidate", Candidate.class);
		List<Candidate> candidates = theQuery.getResultList();

		currentSession.close();
		return candidates;
	}
	
	public List<Candidate> getCandidateList() {
		Session currentSession = entityManager.unwrap(Session.class);
		TypedQuery<Candidate> theQuery = currentSession.createQuery("from Candidate", Candidate.class);
		List<Candidate> candidates = theQuery.getResultList();

		currentSession.close();
		return candidates;
	}
	
	@Transactional
	public void addCandidate(final Candidate candidate) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(candidate);
		currentSession.close();
	}

	@Transactional
	public void updateCandidate(final Candidate candidate) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(candidate);
		currentSession.close();
	}

	@Transactional
	public void deleteCandidate(final int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Candidate candidate = currentSession.get(Candidate.class, id);
		currentSession.remove(candidate);
		currentSession.close();		
	}
	
	@Transactional
	public void updateVote(final Candidate candidate) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.merge(candidate);
		currentSession.close();
	}

}
