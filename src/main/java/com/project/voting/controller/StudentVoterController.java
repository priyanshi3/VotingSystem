package com.project.voting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.voting.entity.Candidate;
import com.project.voting.entity.StudentVoter;
import com.project.voting.service.StudentVoterService;

@Controller
public class StudentVoterController {

	@Autowired
	private StudentVoterService studentVoterService;
	
	@GetMapping("/studentVoters")
	public String getVoters(ModelMap voterModel) {
		List<StudentVoter> voters = studentVoterService.getVoters();
		voterModel.addAttribute("voters", voters);
		return "voters";
	}
	
	public String getVoter(@PathVariable int id, ModelMap voterModel) {
		StudentVoter voter = studentVoterService.getVoter(id);
		voterModel.addAttribute("voter", voter);
		return "voter";
	}
	
	public String updateVoter(@RequestParam int id, @RequestParam(value = "stuName", required = true) String stuName,
			@RequestParam(value = "stuRollNo", required = true) String stuRollNo, ModelMap candidateModel) {
		StudentVoter voter = new StudentVoter(id, stuRollNo, stuName);
		studentVoterService.updateVoter(voter);
		return "redirect:/vote";
	}
	
	@GetMapping("/voted")
	public String votedPage() {
		return "voted";
	}
}
