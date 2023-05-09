package com.project.voting.controller;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.voting.entity.Login;
import com.project.voting.entity.StudentVoter;
import com.project.voting.repository.StuRepo;
import com.project.voting.repository.UserRepo;
import com.project.voting.service.LoginService;
import com.project.voting.service.StudentVoterService;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private StudentVoterService studentVoterService;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private StuRepo stuRepo;
	
	HttpSession session;
	String usrname, pwd;
	
	@PostConstruct
	private void postConstruct() {
		Login admin = new Login("ADMIN", "ADMIN");
		Login user1 = new Login("CE093", "PRIYANSHI");
		Login user2 = new Login("CE053", "NETRA");
		StudentVoter stu1 = new StudentVoter("CE093", "PRIYANSHI PARSANIYA");
		StudentVoter stu2 = new StudentVoter("CE053", "NETRA JADAV");
		userRepo.save(admin);
		userRepo.save(user1);
		userRepo.save(user2);
		stuRepo.save(stu1);
		stuRepo.save(stu2);
	}
	
	@GetMapping("login")
	public String loginPage() {
		return "loginUser";
	}
	
	@PostMapping("/loginUser/user")
	public String validateUser(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password, 
			ModelMap candidateModel, 
			RedirectAttributes redirAttr, 
			HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		List<Login> users = loginService.getUsers();
		for(Login usr : users) {
			if(username.equals(usr.getUsername()) && password.equals(usr.getPassword())) {
				candidateModel.addAttribute("user", usr);
				candidateModel.addAttribute(username);
				candidateModel.addAttribute(password);
				candidateModel.addAttribute("msg", "Login user successfully");
				
				//session check
				session = request.getSession();
				usrname = (String) request.getParameter("usr");
				pwd = (String) request.getParameter("pwd");
				if(username.equals("ADMIN") && password.equals("ADMIN")) {
					session.setAttribute("admin", username);
					session.setAttribute("pwdAdmin", password);
					return "redirect:/candidates";
				}	
				List<StudentVoter> voters = studentVoterService.getVoters();
				for(StudentVoter voter : voters) {
					if(username.equals(voter.getStuRollNo())) {
						if(voter.getVoted() == null) {
							session.setAttribute("usr", username);
							session.setAttribute("pwd", password);
							return "redirect:/vote";
						}
						else {
							return "redirect:/voted";
						}
					}
				}
				
			}
		}
		redirAttr.addFlashAttribute("error", "Invalid username or password");
		return "redirect:/login";
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, 
			HttpServletResponse response) {
		
		session = request.getSession();
		
		if(!session.isNew()) {
			if(request.getParameter("logout") == "admin") {
				session.removeAttribute("admin");
			}
			if(request.getParameter("logout") == "user") {
				session.removeAttribute("usr");
			}
		}
		return "redirect:/login";
	}
	
	
	
}

