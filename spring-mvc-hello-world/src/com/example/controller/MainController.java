package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.formbacker.PersonalInfoFormBacker;
import com.example.service.ServiceInterface;


@Controller
public class MainController {
	//activities are now methods, not anymore servlets
	//the names of class and methods do not influence their actions
	//dissociates the url and the code
	//the empty string is a reference to the dispatcher servlet itself
	@RequestMapping("/hello")
	public String helloController(Model model){
		System.out.println("Hello World!");
		model.addAttribute("messageFromController", "Frank");
		
		//The big form will need the backing bean, we pack it in here.
		//make sure the entire backer is assembled, empty
		PersonalInfoFormBacker formBacker = new PersonalInfoFormBacker();
		//prepopulate the fields: e.g. edit profile
		formBacker.getName().setFirstName("Procopio");
		formBacker.getName().setLastName("Pahlpak");
		model.addAttribute("personalInfoForm", formBacker);
		return "hello-world";
	}
	//return value is always string: signal to where to go: forward to some location
	//the ability to go forward is in the dispatcher servlet: his the session, request, etc.
	//the string represents the name of the jsp file
	//view resolver: prefixes /WEB-INF/jsp and suffixes .jsp
	
	//Two options to transport request attributes
	//HttpServletRequest request
	//Model model
	//these are made available by the dispatcher servlet: passed by reference
	
	//put in the param list the things we need, if we need access to request,
	
	@RequestMapping(value="/hello2", method=RequestMethod.GET)
	public String helloController2(
			@RequestParam("sampleParameter") String sampleParam,
			Model model){
		model.addAttribute("msg", sampleParam);
		return "hello-world2";
	}
	
	@RequestMapping("/hello3")
	public String helloController3(){
		return "redirect:/hello";
	}
	
	@RequestMapping(value="/secondAction", method=RequestMethod.POST)
	public String secondAction(@RequestParam("formSubmissionData") String submittedData, Model model){
		model.addAttribute("dataFeed", submittedData);
		return "hello-world2";
	}
	
	@Autowired
	private ServiceInterface service;
	
	@RequestMapping(value="/fourthAction")
	public String fourthDemonstrationMethodGet(Model model){
		String dataFromService = service.fetchData();
		model.addAttribute("dataFeed", dataFromService);
		return "hello-world2";
	}
	
	//how to get the session
	@RequestMapping(value="/fifthAction")
	public String fifthDemonstrationMethodGet(HttpSession session){
		return "hello-world2";
	}
		
	@RequestMapping(value="/sixthAction")
	public String sixthDemonstrationMethodGet(
			PersonalInfoFormBacker form){
		System.out.println(form.getName().getFirstName());
		System.out.println(form.getName().getLastName());
		return "hello-world2";
	}
}
