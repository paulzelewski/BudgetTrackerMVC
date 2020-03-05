package com.pzelewski.BudgetTrackerMVC.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pzelewski.BudgetTrackerMVC.models.Budget;
import com.pzelewski.BudgetTrackerMVC.models.Transaction;
import com.pzelewski.BudgetTrackerMVC.models.User;
import com.pzelewski.BudgetTrackerMVC.security.UserPrincipal;
import com.pzelewski.BudgetTrackerMVC.services.BudgetService;
import com.pzelewski.BudgetTrackerMVC.services.TransactionService;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired TransactionService transactionService;
	@Autowired BudgetService budgetService;
	
	@GetMapping
	public String getAccount(@AuthenticationPrincipal UserPrincipal userPrincipal, Model model) {
		
		model.addAttribute("title","Account");
		model.addAttribute("activateAccount", "active");
		//TODO load user transactions
		User user = userPrincipal.getUser();
		user.setTransactions(transactionService.findByUser(user));
		Set<Transaction> userTransactions = user.getTransactions();
		
		if(userTransactions.isEmpty()) {
			model.addAttribute("noTransactions", "You don't have any transactions..");
		}else {
			model.addAttribute("userTransactions", userTransactions);
		}
		
		//TODO load user budgets
		user.setBudgets(budgetService.findBudgetByUser(user));
		Set<Budget> userBudgets = user.getBudgets();
		if(userBudgets.isEmpty()) {
			model.addAttribute("noBudgets", "You don't have any budgets..");
		}else {
			model.addAttribute("userBudgets", userBudgets);
		}
		
		return "account";
	}
	
}
