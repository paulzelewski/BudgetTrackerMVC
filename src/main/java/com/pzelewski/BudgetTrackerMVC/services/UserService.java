package com.pzelewski.BudgetTrackerMVC.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.pzelewski.BudgetTrackerMVC.models.User;
import com.pzelewski.BudgetTrackerMVC.web.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	
	User findByUserEmail(String userEmail);
	User saveUser(UserRegistrationDto register);

}
