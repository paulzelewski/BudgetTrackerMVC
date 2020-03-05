package com.pzelewski.BudgetTrackerMVC.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import com.pzelewski.BudgetTrackerMVC.models.Budget;
import com.pzelewski.BudgetTrackerMVC.models.Transaction;
import com.pzelewski.BudgetTrackerMVC.models.User;
import com.pzelewski.BudgetTrackerMVC.security.UserPrincipal;
import com.pzelewski.BudgetTrackerMVC.web.AddUpdateTransactionDto;

public interface TransactionService {
	
	Set<Transaction> findByUser(User user);
	Set<Transaction> findByUserAndBudget(User user, Budget budget);
	AddUpdateTransactionDto findByUserAndId(UserPrincipal userPrincipal, Long transactionId);
	
	//TODO need extra sorting by date etc.
	
	String addTransaction(UserPrincipal userPrincipal, AddUpdateTransactionDto transactionDto);
	String deleteTransactionByUserAndId(UserPrincipal userPrincipal, Long transactionId);
	String updateTransaction(UserPrincipal userPrincipal, AddUpdateTransactionDto transactionDto, Long transactionId);
	void setBudgetIntoTransactions(User user, Long budgetId, List<Long> transactionIds);
	BigDecimal getSumOfTransactions(Budget budget);
	

}
