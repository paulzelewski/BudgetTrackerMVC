package com.pzelewski.BudgetTrackerMVC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pzelewski.BudgetTrackerMVC.models.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
