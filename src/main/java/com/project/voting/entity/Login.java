package com.project.voting.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "login")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int loginId;
	
	@Column
	private String username;
	
	@Column
	private String password;

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Login(int loginId, String username, String password) {
		super();
		this.loginId = loginId;
		this.username = username;
		this.password = password;
	}

	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
