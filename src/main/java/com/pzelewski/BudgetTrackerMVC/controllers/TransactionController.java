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
import com.pzelewski.BudgetTrackerMVC.services.TransactionService;
import com.pzelewski.BudgetTrackerMVC.web.AddUpdateTransactionDto;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired TransactionService transactionService;
	
	@ModelAttribute("transactionDto")
	public AddUpdateTransactionDto addUpdateTransactionDto(Model model) {
		
		model.addAttribute("title", "Add transaction");
		return new AddUpdateTransactionDto();
	}	 
	
	@GetMapping
	public ModelAndView getTransaction(ModelAndView mav) {
		
		mav.addObject("action", "/transaction");
		mav.setViewName("transaction");
		return mav;
	}
		
	@PostMapping
	public ModelAndView addTransaction(ModelAndView mav,@ModelAttribute("transactionDto") @Valid AddUpdateTransactionDto transactionDto, BindingResult result, @AuthenticationPrincipal UserPrincipal userPrincipal) {
				
		if(result.hasErrors()) {
			mav.setViewName("transaction");
			return mav;
		}
		
		transactionService.addTransaction(userPrincipal,transactionDto);
		
		mav.setViewName("redirect:/account");
		
		return mav;
	}
	
	@GetMapping("/{transactionId}")
	public ModelAndView getTransaction(ModelAndView mav,@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable Long transactionId) {
		
		AddUpdateTransactionDto transactionDto = transactionService.findByUserAndId(userPrincipal, transactionId);
		mav.addObject("transactionDto", transactionDto);
		mav.addObject("action", "/transaction/"+transactionId);
		mav.setViewName("transaction");
		return mav;
	}
	
	@PostMapping("/{transactionId}")
	public ModelAndView updateTransaction(ModelAndView mav,@ModelAttribute("transactionDto") @Valid AddUpdateTransactionDto transactionDto, BindingResult result,
			@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable Long transactionId) {
				
		if(result.hasErrors()) {
			mav.setViewName("transaction");
			return mav;
		}
		
		transactionService.updateTransaction(userPrincipal, transactionDto, transactionId);
		
		mav.setViewName("redirect:/account");
		
		return mav;
	}
	
	@DeleteMapping("/{transactionId}")
	public ModelAndView deleteTransaction(@PathVariable Long transactionId,@AuthenticationPrincipal UserPrincipal userPrincipal, ModelAndView mav) {
		
		String message = transactionService.deleteTransactionByUserAndId(userPrincipal, transactionId);
			
		mav.addObject("status", message);
		mav.setViewName("redirect:/account");
		
		return mav;
	}
}
