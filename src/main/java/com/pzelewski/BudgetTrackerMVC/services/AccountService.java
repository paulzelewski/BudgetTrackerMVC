package com.pzelewski.BudgetTrackerMVC.services;

import java.math.BigDecimal;

import com.pzelewski.BudgetTrackerMVC.models.Account;
import com.pzelewski.BudgetTrackerMVC.models.User;

public interface AccountService {
	
	Account createAccount(User user);
	void addAccountBalance(User user, BigDecimal transactionAmount);
	void subtractAccountBalance(User user, BigDecimal transactionAmount);

}
