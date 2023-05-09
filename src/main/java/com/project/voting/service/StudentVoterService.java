package com.project.voting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.voting.entity.Candidate;
import com.project.voting.entity.StudentVoter;
import com.project.voting.repository.StudentVoterDAO;

@Service
public class StudentVoterService {

	@Autowired
	private StudentVoterDAO studentVoterDao;
	
	public List<StudentVoter> getVoters() {
		return studentVoterDao.getVoters();
	}
	
	public StudentVoter getVoter(final int id) {
		return studentVoterDao.getVoter(id);
	}
	
	public void updateVoter(final StudentVoter voter) {
		studentVoterDao.updateVoter(voter);
	}
}
