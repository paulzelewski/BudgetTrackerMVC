package com.pzelewski.BudgetTrackerMVC.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
	
	@GetMapping({"/","home"})	
	public ModelAndView getHome() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("title", "Home");
		mv.addObject("activateHome", "active");
		return mv;
	}
	
	@GetMapping("/login")
	public ModelAndView getLogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		mv.addObject("title", "Login");
		mv.addObject("activateLogin", "active");
		return mv;
	}
	
	@GetMapping("/error")
	public ModelAndView getError() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		mav.addObject("title", "Error");
		return mav;
	}

}
