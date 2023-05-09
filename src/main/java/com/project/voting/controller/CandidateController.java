package com.project.voting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.voting.entity.Candidate;
import com.project.voting.entity.StudentVoter;
import com.project.voting.service.CandidateService;
import com.project.voting.service.StudentVoterService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private StudentVoterService studentVoterService;
	
	HttpSession session;
	String usrname;

	//get specific candidate
	@GetMapping("/candidate/{id}")
	public String getCandidate(@PathVariable int id, ModelMap candidateModel) {
		Candidate candidate = candidateService.getCandidate(id);
		candidateModel.addAttribute("candidate", candidate);
		return "candidate";
	}

	//get all candidates list 
	@GetMapping("/candidates")
	public String getCandidates(ModelMap candidateModel) {
		List<Candidate> candidates = candidateService.getCandidates();
		candidateModel.addAttribute("candidates", candidates);
		return "candidates";
	}
	
	//get all candidate list to vote
	@GetMapping("/vote")
	public String getCandidateList(ModelMap candidateModel) {
		List<Candidate> candidates = candidateService.getCandidates();
		candidateModel.addAttribute("candidates", candidates);
		return "vote";
	}

	//add new candidate
	@GetMapping("addCandidate")
	public String addPage() {
		return "add";
	}

	@PostMapping("/add/candidate")
	public String addCandidate(@RequestParam(value = "cand_name", required = true) String cand_name,
			@RequestParam(value = "party_name", required = true) String party_name, ModelMap candidateModel) {
		Candidate candidate = new Candidate();
		candidate.setCand_name(cand_name);
		candidate.setParty_name(party_name);
		candidate.setVote(0);
		candidateService.addCandidate(candidate);
		candidateModel.addAttribute("msg", "Candidate added successfully");
		List<Candidate> candidates = candidateService.getCandidates();
		candidateModel.addAttribute("candidates", candidates);
		return "redirect:/candidates";
	}

	//update existing candidate
	@GetMapping("update/candidate/{id}")
	public String updatePage(@PathVariable("id") int id, ModelMap candidateModel) {
		candidateModel.addAttribute("id", id);
		Candidate candidate = candidateService.getCandidate(id);
		candidateModel.addAttribute("candidate", candidate);
		return "update";
	}

	@PostMapping("/update/candidate")
	public String updateCandidate(@RequestParam int id, @RequestParam(value = "cand_name", required = true) String cand_name,
			@RequestParam(value = "party_name", required = true) String party_name, ModelMap candidateModel) {
		Candidate candidate = new Candidate(id,cand_name,party_name);
		candidateService.updateCandidate(candidate);
		List<Candidate> candidates = candidateService.getCandidates();
		candidateModel.addAttribute("candidates", candidates);
		candidateModel.addAttribute("id", id);
		candidateModel.addAttribute("msg", "Candidate updated successfully");
		return "redirect:/candidates";
	}

	//delete candidate
	@GetMapping("/delete/candidate/{id}")
	public String deleteCandidate(@PathVariable int id, ModelMap candidateModel) {		
		candidateService.deleteCandidate(id);
		List<Candidate> candidates = candidateService.getCandidates();
		candidateModel.addAttribute("candidates", candidates);
		candidateModel.addAttribute("msg", "Candidate deleted successfully");
		return "redirect:/candidates";
	}
	
	//update number of vote of candidate
	@GetMapping("/updateVote/candidate/{id}")
	public String updateVote(@PathVariable("id") int id,
			HttpServletRequest request, 
			ModelMap candidateModel, 
			RedirectAttributes redirAttr) {
		Candidate candidate = candidateService.getCandidate(id);
		int vote = candidate.getVote();
		candidate.setVote(++vote);
		candidateService.updateCandidate(candidate);
		
		session = request.getSession();
		usrname = (String) session.getAttribute("usr");
		List<StudentVoter> voters = studentVoterService.getVoters();
		for(StudentVoter voter : voters) {
			if(usrname.equals(voter.getStuRollNo())) {
				updateVoted(candidate.getCand_name(), voter.getStuId());
			}
		}
		redirAttr.addFlashAttribute("voted", "You have voted successfully");
		return "redirect:/voted";
	}

	public void updateVoted(String cand, int voter_id) {
		StudentVoter voter = studentVoterService.getVoter(voter_id);
		voter.setVoted(cand);
		studentVoterService.updateVoter(voter);
	}
}
