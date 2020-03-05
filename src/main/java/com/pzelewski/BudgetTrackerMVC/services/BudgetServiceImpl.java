package com.pzelewski.BudgetTrackerMVC.services;

import java.util.NoSuchElementException;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzelewski.BudgetTrackerMVC.models.Budget;
import com.pzelewski.BudgetTrackerMVC.models.User;
import com.pzelewski.BudgetTrackerMVC.repositories.BudgetRepository;
import com.pzelewski.BudgetTrackerMVC.security.UserPrincipal;
import com.pzelewski.BudgetTrackerMVC.web.AddUpdateBudgetDto;

@Service
@Transactional
public class BudgetServiceImpl implements BudgetService {
	
	@Autowired BudgetRepository budgetRepository;

	@Override
	public String addBudget(UserPrincipal userPrincipal, AddUpdateBudgetDto budgetDto) {
		
		Budget budget = new Budget();
		User user = userPrincipal.getUser();		
		budget.setBudgetName(budgetDto.getBudgetName());
		budget.setBudgetAmount(budgetDto.getBudgetAmount());
		budget.setBudgetStartDate(budgetDto.getBudgetStartDate());
		budget.setBudgetEndDate(budgetDto.getBudgetEndDate());
		budget.setUser(user);
		budgetRepository.save(budget);
		return "Budget saved successfully!";
	}

	@Override
	public Set<Budget> findBudgetByUser(User user) {
		
		return budgetRepository.findByUser(user);
	}

	@Override
	public void deleteBudgetByUserAndId(UserPrincipal userPrincipal, Long budgetId) {
		
		User user = userPrincipal.getUser();			
		budgetRepository.deleteByUserAndBudgetId(user, budgetId);		
		
	}

	@Override
	public AddUpdateBudgetDto findBudgetByUserAndId(UserPrincipal userPrincipal, Long budgetId) throws NoSuchElementException {
		
		AddUpdateBudgetDto budgetDto = new AddUpdateBudgetDto();
		Budget budget = budgetRepository.findByUserAndBudgetId(userPrincipal.getUser(), budgetId)
				.orElseThrow(() -> new NoSuchElementException("Budget not found."));
		
		budgetDto.setBudgetName(budget.getBudgetName());
		budgetDto.setBudgetAmount(budget.getBudgetAmount());
		budgetDto.setBudgetStartDate(budget.getBudgetStartDate());
		budgetDto.setBudgetEndDate(budget.getBudgetEndDate());
		
		return budgetDto;
	}

	@Override
	public String updateBudget(UserPrincipal userPrincipal, AddUpdateBudgetDto budgetDto, Long budgetId) throws NoSuchElementException {
		
		User user = userPrincipal.getUser();
		Budget budget = budgetRepository.findByUserAndBudgetId(user, budgetId)
				.orElseThrow(() -> new NoSuchElementException("Budget not found."));
		
		//budget.setBudgetId(budgetId);
		budget.setBudgetName(budgetDto.getBudgetName());
		budget.setBudgetAmount(budgetDto.getBudgetAmount());
		budget.setBudgetStartDate(budgetDto.getBudgetStartDate());
		budget.setBudgetEndDate(budgetDto.getBudgetEndDate());
		//budget.setUser(user);
		
		budgetRepository.save(budget);
		return "Budget saved successfully!";
	}
		
}
