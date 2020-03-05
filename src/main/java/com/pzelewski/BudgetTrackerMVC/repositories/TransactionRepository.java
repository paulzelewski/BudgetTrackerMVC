package com.pzelewski.BudgetTrackerMVC.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pzelewski.BudgetTrackerMVC.models.Budget;
import com.pzelewski.BudgetTrackerMVC.models.Transaction;
import com.pzelewski.BudgetTrackerMVC.models.User;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	Set<Transaction> findByUser(User user);
	Set<Transaction> findByUserAndBudget(User user, Budget budget);
	@Query("select t.transactionId from Transaction t where t.user = ?1 and (t.budget is null or t.budget = ?2)")
	List<Long> findIdsByUserAndBudget(User user, Budget budget);
	void deleteByUserAndTransactionId(User user, Long transactionId);
	Optional<Transaction> findByUserAndTransactionId(User user, Long transactionId);
	@Query("select sum(t.transactionAmount) from Transaction t where t.budget = ?1")
	BigDecimal sumBudgetTransactions(Budget budget);

}
