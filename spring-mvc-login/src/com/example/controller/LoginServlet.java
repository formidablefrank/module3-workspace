package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.User;
import com.example.service.LoginService;

@Controller
public class LoginServlet {
	@Autowired
	LoginService service;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(
			HttpServletRequest request,
			HttpSession session,
			@RequestParam("username") String username,
			@RequestParam("password") String password){
		
		if(service.isValid(new User(username, password))){
			session = request.getSession(true);
			session.setAttribute("username", username);
			request.setAttribute("msg", username);
		}
		else{
			request.setAttribute("msg", "Invalid credentials!");
		}
		return "home";
	}
}
