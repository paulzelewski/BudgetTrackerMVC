package com.pzelewski.BudgetTrackerMVC.services;

import java.util.Set;

import com.pzelewski.BudgetTrackerMVC.models.Budget;
import com.pzelewski.BudgetTrackerMVC.models.User;
import com.pzelewski.BudgetTrackerMVC.security.UserPrincipal;
import com.pzelewski.BudgetTrackerMVC.web.AddUpdateBudgetDto;

public interface BudgetService {
	
	String addBudget(UserPrincipal userPrincipal, AddUpdateBudgetDto budgetDto);
	String updateBudget(UserPrincipal userPrincipal, AddUpdateBudgetDto budgetDto, Long budgetId);

	Set<Budget> findBudgetByUser(User user);
	AddUpdateBudgetDto findBudgetByUserAndId(UserPrincipal userPrincipal, Long budgetId);

	void deleteBudgetByUserAndId(UserPrincipal userPrincipal, Long budgetId);
	
	

	

}
