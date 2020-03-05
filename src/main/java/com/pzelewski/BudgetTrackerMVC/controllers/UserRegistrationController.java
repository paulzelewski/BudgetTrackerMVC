package com.pzelewski.BudgetTrackerMVC.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.pzelewski.BudgetTrackerMVC.models.User;
import com.pzelewski.BudgetTrackerMVC.services.UserService;
import com.pzelewski.BudgetTrackerMVC.web.UserRegistrationDto;

@Controller
public class UserRegistrationController {
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("userRegistrationDto")
	public UserRegistrationDto userRegistrationDto(Model model) {
		model.addAttribute("title", "Register");
		model.addAttribute("activateSignon", "active");
		return new UserRegistrationDto();
	}
	
	@GetMapping("/register")
	public String getRegister(Model model) {
		
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUserAccount(@ModelAttribute("userRegistrationDto") @Valid UserRegistrationDto userDto,BindingResult result) {
		
		User existing = userService.findByUserEmail(userDto.getUserEmail());
        if (existing != null) {
            result.rejectValue("userEmail", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
        	        	
            return "register";
        }
		
        existing = userService.saveUser(userDto); //TODO assigning to existing not needed
        System.out.println(existing.getUserId()+" "+existing.getUserPassword()); //TODO Testing, remove me
        return "redirect:/login?registered";
	}
}
