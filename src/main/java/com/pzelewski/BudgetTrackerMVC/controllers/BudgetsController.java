package com.pzelewski.BudgetTrackerMVC.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pzelewski.BudgetTrackerMVC.models.Budget;
import com.pzelewski.BudgetTrackerMVC.models.Transaction;
import com.pzelewski.BudgetTrackerMVC.models.User;
import com.pzelewski.BudgetTrackerMVC.security.UserPrincipal;
import com.pzelewski.BudgetTrackerMVC.services.BudgetService;
import com.pzelewski.BudgetTrackerMVC.services.TransactionService;

@RestController
@RequestMapping("/budgets")
public class BudgetsController {
	
	@Autowired BudgetService budgetService;
	@Autowired TransactionService transactionService;
	
	@ModelAttribute
	public Model setAttributes(Model model) {
		
		model.addAttribute("title", "Budgets");
		return model.addAttribute("activateBudgets", "active");
	}

	@GetMapping
	public ModelAndView getBudgets(ModelAndView mav, @AuthenticationPrincipal UserPrincipal userPrincipal) {
		
		User user = userPrincipal.getUser();
		user.setBudgets(budgetService.findBudgetByUser(user));
		for(Budget budget : user.getBudgets()) {
			budget.setBudgetUsedAmount(transactionService.getSumOfTransactions(budget));
		}
		Set<Transaction> userTransactions = transactionService.findByUserAndBudget(user, null);
		Set<Budget> userBudgets = user.getBudgets();
		
		if(userBudgets.isEmpty()) {
			mav.addObject("noBudgets", "You don't have any budgets..");
		}else {
			mav.addObject("userBudgets", userBudgets);
		}
		
		if(userTransactions.isEmpty()) {
			mav.addObject("noTransactions", "You don't have any transactions..");
		}else {
			mav.addObject("userTransactions", userTransactions);
		}
		
		mav.setViewName("budgets");
		return mav;
	}
	
	@PostMapping("/assignTransactions")	
	public ModelAndView setBudgetIntoTransactions(ModelAndView mav, @AuthenticationPrincipal UserPrincipal userPrincipal,
			@RequestParam("budgetId") Long budgetId, @RequestParam("transactionIds") List<Long> transactionIds) {
		
		//TODO testing delete me
		System.out.println("assign transactions to budgetId="+budgetId+"transactionIds: "+transactionIds.toString());
		User user = userPrincipal.getUser();
		transactionService.setBudgetIntoTransactions(user, budgetId, transactionIds);
		mav.setViewName("redirect:/budgets");
		return mav;
	}
}
