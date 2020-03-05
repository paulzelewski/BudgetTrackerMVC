package com.pzelewski.BudgetTrackerMVC.repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pzelewski.BudgetTrackerMVC.models.Budget;
import com.pzelewski.BudgetTrackerMVC.models.User;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
	
	//TODO
	Set<Budget> findByUser(User user);
	Optional<Budget> findByUserAndBudgetId(User user, Long budgetId);

	void deleteByUserAndBudgetId(User user, Long budgetId);

	
}
