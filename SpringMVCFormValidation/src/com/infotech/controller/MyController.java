package com.infotech.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infotech.model.Student;
import com.infotech.model.StudentCredential;
import com.infotech.service.StudentService;

@Controller
public class MyController {
	
	@Autowired
	private StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	public StudentService getStudentService() {
		return studentService;
	}
	
	@RequestMapping(value ="/" ,method=RequestMethod.GET)
	public String homePage(){
		return "home";
	}
	@RequestMapping(value ="/login" ,method=RequestMethod.GET)
	public String loginPage(Model model){
		model.addAttribute("studentCredential", new StudentCredential());
		return "login";
	}

	@RequestMapping(value ="/register" ,method=RequestMethod.GET)
	public String registerPage(Model model){
		model.addAttribute("student", new Student());
		return "register";
	}

	@RequestMapping(value ="/registerSuccess" ,method=RequestMethod.POST)
	public ModelAndView registerSuccess(@Valid @ModelAttribute("student") Student student,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("register");
		}
		getStudentService().registerStudent(student);
		ModelAndView modelAndView = new ModelAndView("welcome");
		modelAndView.addObject("student", student);
		return modelAndView;
	}
	@RequestMapping(value ="/loginSuccess" ,method=RequestMethod.POST)
	public ModelAndView loginSuccess(@Valid @ModelAttribute("studentCredential") StudentCredential studentCredential,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("login");
		}
		
		ModelAndView modelAndView = new ModelAndView("welcome");
		Student student = getStudentService().validateStudentCredential(studentCredential.getEmail(), studentCredential.getPassword());
		if(student!= null){
			modelAndView.addObject("student", student);
			return modelAndView;
		}else{
			 modelAndView = new ModelAndView("notFound");
		}
		return modelAndView;
	}
	
	@ModelAttribute
	public void headerMessage(Model model){
		model.addAttribute("headerMessage", "Welcome to Starve Technology");
		
		List<String> techList = new ArrayList<>();
		techList.add("Hibernate");
		techList.add("Spring");
		techList.add("JSP");
		techList.add("Servlet");
		techList.add("Struts");
		
		List<String> citesList = new ArrayList<>();
		citesList.add("Pune");
		citesList.add("Chennai");
		citesList.add("Delhi");
		citesList.add("Other");
		
		model.addAttribute("technologyList", techList);
		model.addAttribute("citesList", citesList);
	}
}
