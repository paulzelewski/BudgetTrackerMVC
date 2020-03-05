package com.pzelewski.BudgetTrackerMVC.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/personal")
public class PersonalController {
	
	@ModelAttribute("title")
	public Model setTitle(Model model) {
		
		model.addAttribute("activatePersonal", "active");
		return model.addAttribute("title", "Personal details");
	}
	
	@GetMapping
	public ModelAndView getPersonal(ModelAndView mav){
		
		
		mav.setViewName("personal");
		return mav;
	}

}
