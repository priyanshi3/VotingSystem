package com.project.voting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.voting.entity.Candidate;
import com.project.voting.repository.CandidateDAO;

@Service
public class CandidateService {

	@Autowired
	private CandidateDAO candidateDao;

	public Candidate getCandidate(final int id) {
		return candidateDao.getCandidate(id);
	}

	public List<Candidate> getCandidates() {
		return candidateDao.getCandidates();
	}
	
	public List<Candidate> getCandidateList() {
		return candidateDao.getCandidateList();
	}

	public void addCandidate(final Candidate candidate) {
		candidateDao.addCandidate(candidate);
	}

	public void updateCandidate(final Candidate candidate) {
		candidateDao.updateCandidate(candidate);
	}

	public void deleteCandidate(final int id) {
		candidateDao.deleteCandidate(id);
	}

	public void updateVote(final Candidate candidate) {
		candidateDao.updateVote(candidate);
	}
}
