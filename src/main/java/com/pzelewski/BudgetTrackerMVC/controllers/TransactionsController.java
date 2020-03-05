package com.pzelewski.BudgetTrackerMVC.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pzelewski.BudgetTrackerMVC.models.Transaction;
import com.pzelewski.BudgetTrackerMVC.models.User;
import com.pzelewski.BudgetTrackerMVC.security.UserPrincipal;
import com.pzelewski.BudgetTrackerMVC.services.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {
	
	@Autowired TransactionService transactionService;
	
	@ModelAttribute("title")
	public Model setTitle(Model model) {
		
		model.addAttribute("activateTransactions", "active");
		return model.addAttribute("title", "Transactions");
	}
		
	@GetMapping
	public ModelAndView getTransactions(ModelAndView mav, @AuthenticationPrincipal UserPrincipal userPrincipal) {
		
		User user = userPrincipal.getUser();
		user.setTransactions(transactionService.findByUser(user));
		Set<Transaction> userTransactions = user.getTransactions();
		
		if(userTransactions.isEmpty()) {
			mav.addObject("noTransactions", "You don't have any transactions..");
		}else {
			mav.addObject("userTransactions", userTransactions);
		}
		
		mav.setViewName("transactions");
		return mav;
	}
}
