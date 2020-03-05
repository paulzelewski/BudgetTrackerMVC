package com.pzelewski.BudgetTrackerMVC.services;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzelewski.BudgetTrackerMVC.models.Account;
import com.pzelewski.BudgetTrackerMVC.models.User;
import com.pzelewski.BudgetTrackerMVC.repositories.AccountRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired AccountRepository accountRepository;
	
	@Override
	public Account createAccount(User user) {
		final BigDecimal INITIAL_ACCOUNT_BALANCE = new BigDecimal("0.00");
		Account account = new Account();
        account.setUser(user);
        account.setAccountBalance(INITIAL_ACCOUNT_BALANCE);
        account.setAccountCreationDate(LocalDate.now());
        return account;
	}

	@Override
	public void addAccountBalance(User user, BigDecimal transactionAmount) {
		
		Account account = user.getAccount();
		account.setAccountBalance(account.getAccountBalance().add(transactionAmount));
		accountRepository.save(account);
		
	}

	@Override
	public void subtractAccountBalance(User user, BigDecimal transactionAmount) {
		
		Account account = user.getAccount();
		account.setAccountBalance(account.getAccountBalance().subtract(transactionAmount));
		accountRepository.save(account);
		
	}
}
