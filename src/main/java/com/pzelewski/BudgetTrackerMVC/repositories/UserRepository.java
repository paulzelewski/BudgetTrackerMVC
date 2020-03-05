package com.pzelewski.BudgetTrackerMVC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pzelewski.BudgetTrackerMVC.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	//User findByUserName(String userName); userName is no longer unique
	User findByUserEmail(String userEmail);

}
