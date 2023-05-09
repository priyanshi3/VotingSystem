package com.project.voting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.voting.entity.Login;
import com.project.voting.repository.LoginDAO;

@Service
public class LoginService {

	@Autowired
	private LoginDAO loginDao;
	
	public List<Login> getUsers() {
		return loginDao.getUsers();
	}
	
	public void validateUser(final Login user) {
		loginDao.validateUser(user);
	}
		
}
