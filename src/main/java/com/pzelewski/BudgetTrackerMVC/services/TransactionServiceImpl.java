package com.pzelewski.BudgetTrackerMVC.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzelewski.BudgetTrackerMVC.models.Budget;
import com.pzelewski.BudgetTrackerMVC.models.Transaction;
import com.pzelewski.BudgetTrackerMVC.models.User;
import com.pzelewski.BudgetTrackerMVC.repositories.BudgetRepository;
import com.pzelewski.BudgetTrackerMVC.repositories.TransactionRepository;
import com.pzelewski.BudgetTrackerMVC.security.UserPrincipal;
import com.pzelewski.BudgetTrackerMVC.web.AddUpdateTransactionDto;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired TransactionRepository transactionRepository;
	@Autowired BudgetRepository budgetRepository;
	
	@Autowired AccountService accountService;
	
	@Override
	public Set<Transaction> findByUser(User user) {
				
		return transactionRepository.findByUser(user);
	}

	@Override
	public String addTransaction(UserPrincipal userPrincipal, AddUpdateTransactionDto transactionDto) {
		
		Transaction transaction = new Transaction();
		User user = userPrincipal.getUser();
				
		transaction.setTransactionDate(transactionDto.getTransactionDate());
		transaction.setNote(transactionDto.getNote());
		transaction.setTransactionAmount(transactionDto.getTransactionAmount());
		transaction.setUser(user);				
		transaction = transactionRepository.save(transaction);
		
		accountService.addAccountBalance(user, transaction.getTransactionAmount());
		
		return "Transaction saved successfully!";

	}

	@Override
	public String deleteTransactionByUserAndId(UserPrincipal userPrincipal, Long transactionId) {
		
		User user = userPrincipal.getUser();
		Transaction transaction = transactionRepository.findByUserAndTransactionId(user, transactionId)
				.orElseThrow(() -> new NoSuchElementException("Transaction not found."));
		transactionRepository.deleteByUserAndTransactionId(user, transactionId);
		accountService.subtractAccountBalance(user, transaction.getTransactionAmount());
		return "Transaction was deleted successfully!";
	}		

	@Override
	public AddUpdateTransactionDto findByUserAndId(UserPrincipal userPrincipal, Long transactionId) {
		
		AddUpdateTransactionDto transactionDto = new AddUpdateTransactionDto();
		Transaction transaction = transactionRepository.findByUserAndTransactionId(userPrincipal.getUser(), transactionId)
				.orElseThrow(() -> new NoSuchElementException("Transaction not found."));
		
		transactionDto.setTransactionDate(transaction.getTransactionDate());
		transactionDto.setNote(transaction.getNote());
		transactionDto.setTransactionAmount(transaction.getTransactionAmount());	
		
		return transactionDto;
	}

	@Override
	public String updateTransaction(UserPrincipal userPrincipal, AddUpdateTransactionDto transactionDto, Long transactionId) {
		
		User user = userPrincipal.getUser();
		Transaction transaction = transactionRepository.findByUserAndTransactionId(user, transactionId)
				.orElseThrow(() -> new NoSuchElementException("Transaction not found."));
		user.getAccount().setAccountBalance(user.getAccount().getAccountBalance().subtract(transaction.getTransactionAmount()));
		transaction.setTransactionDate(transactionDto.getTransactionDate());
		transaction.setNote(transactionDto.getNote());
		transaction.setTransactionAmount(transactionDto.getTransactionAmount());
		
		transaction = transactionRepository.save(transaction);		
		accountService.addAccountBalance(user, transaction.getTransactionAmount());
		
		return "Transaction saved successfully!";		
	}

	@Override
	public Set<Transaction> findByUserAndBudget(User user, Budget budget) {
		
		Set<Transaction> transactions = transactionRepository.findByUserAndBudget(user, budget);
		return transactions;
	}

	@Override
	public void setBudgetIntoTransactions(User user, Long budgetId, List<Long> transactionIds) {
		
		List<Long> persistedTransactionIds = transactionRepository.findIdsByUserAndBudget(user, null);
		transactionIds.retainAll(persistedTransactionIds);
		Budget budget = budgetRepository.findByUserAndBudgetId(user, budgetId).orElseThrow(() -> new NoSuchElementException("Budget not found"));
		
		
		for(Long transactionId : transactionIds) {
			Transaction transaction = transactionRepository.findByUserAndTransactionId(user, transactionId).orElseThrow(() -> new NoSuchElementException("Transaction not found"));
			transaction.setBudget(budget);
			transactionRepository.save(transaction);
		}
		
	}

	@Override
	public BigDecimal getSumOfTransactions(Budget budget) {
		
		BigDecimal sumOfTransactions = transactionRepository.sumBudgetTransactions(budget);
		return sumOfTransactions;
	}

}
