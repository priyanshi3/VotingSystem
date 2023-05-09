package com.project.voting.entity;

import org.eclipse.tags.shaded.org.apache.xpath.operations.Bool;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "studentVoter")
public class StudentVoter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int stuId;
	
	@Column
	private String stuRollNo;
	
	@Column
	private String stuName;
	
	@Column
	private String voted;

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuRollNo() {
		return stuRollNo;
	}

	public void setStuRollNo(String stuRollNo) {
		this.stuRollNo = stuRollNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getVoted() {
		return voted;
	}

	public void setVoted(String voted) {
		this.voted = voted;
	}

	public StudentVoter(int stuId, String stuRollNo, String stuName, String voted) {
		super();
		this.stuId = stuId;
		this.stuRollNo = stuRollNo;
		this.stuName = stuName;
		this.voted = voted;
	}

	public StudentVoter() {
		super();
	}

	public StudentVoter(String stuRollNo, String stuName) {
		super();
		this.stuRollNo = stuRollNo;
		this.stuName = stuName;
	}

	public StudentVoter(int stuId, String stuRollNo, String stuName) {
		super();
		this.stuId = stuId;
		this.stuRollNo = stuRollNo;
		this.stuName = stuName;
	}
	
}
