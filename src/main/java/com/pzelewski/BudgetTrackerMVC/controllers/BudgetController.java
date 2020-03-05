package com.pzelewski.BudgetTrackerMVC.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pzelewski.BudgetTrackerMVC.security.UserPrincipal;
import com.pzelewski.BudgetTrackerMVC.services.BudgetService;
import com.pzelewski.BudgetTrackerMVC.web.AddUpdateBudgetDto;

@RestController
@RequestMapping("/budget")
public class BudgetController {
	
	@Autowired BudgetService budgetService;
	
	@ModelAttribute("budgetDto")
	public AddUpdateBudgetDto addUpdateBudgetDto(Model model) {
		
		model.addAttribute("title", "Budget");
		return new AddUpdateBudgetDto();
	}
	
	@GetMapping
	public ModelAndView getBudget(ModelAndView mav) {
		
		mav.addObject("action", "/budget");
		mav.setViewName("budget");		
		return mav;
	}
	
	@PostMapping
	public ModelAndView addUpdateBudget(ModelAndView mav, @ModelAttribute("budgetDto") @Valid AddUpdateBudgetDto budgetDto,
			BindingResult result, @AuthenticationPrincipal UserPrincipal userPrincipal) {
		
		if(result.hasErrors()) {
			
			mav.setViewName("budget");
			return mav;
		}
		
		budgetService.addBudget(userPrincipal, budgetDto);
		mav.setViewName("redirect:/account");
		return mav;
	}
	
	@GetMapping("/{budgetId}")
	public ModelAndView getBudgetById(ModelAndView mav, @PathVariable Long budgetId,
			@AuthenticationPrincipal UserPrincipal userPrincipal) {
		
		AddUpdateBudgetDto budgetDto = budgetService.findBudgetByUserAndId(userPrincipal, budgetId);
		mav.addObject("budgetDto", budgetDto);
		mav.addObject("action", "/budget/"+budgetId);
		mav.setViewName("budget");		
		return mav;
	}
	
	@PostMapping("/{budgetId}")
	public ModelAndView updateBudget(ModelAndView mav, @ModelAttribute("budgetDto") @Valid AddUpdateBudgetDto budgetDto,
			BindingResult result, @AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable Long budgetId){
		
		if(result.hasErrors()) {
			mav.setViewName("budget");
			return mav;
		}
		
		budgetService.updateBudget(userPrincipal, budgetDto, budgetId);
		mav.setViewName("redirect:/account");
		return mav;
	
	}
	
	@DeleteMapping("/{budgetId}")
	public ModelAndView deleteBudget(ModelAndView mav, @AuthenticationPrincipal UserPrincipal userPrincipal,
			@PathVariable Long budgetId) {
		
		budgetService.deleteBudgetByUserAndId(userPrincipal, budgetId);
		mav.setViewName("redirect:/account");
		return mav;
	}

}
