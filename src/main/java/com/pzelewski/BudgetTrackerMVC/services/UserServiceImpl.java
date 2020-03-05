package com.pzelewski.BudgetTrackerMVC.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.pzelewski.BudgetTrackerMVC.models.User;
import com.pzelewski.BudgetTrackerMVC.repositories.UserRepository;
import com.pzelewski.BudgetTrackerMVC.security.UserPrincipal;
import com.pzelewski.BudgetTrackerMVC.web.UserRegistrationDto;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountService accountService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		User user = userRepository.findByUserEmail(userEmail);
		
		if(user==null) throw new UsernameNotFoundException("Invalid username or password!");
		
		return new UserPrincipal(user);
	}

	@Override
	public User findByUserEmail(String userEmail) {
		
		return userRepository.findByUserEmail(userEmail);
	}

	@Override
	public User saveUser(UserRegistrationDto register) {
		User user = new User();
        user.setUserName(register.getUserName());
        user.setUserEmail(register.getUserEmail());
        user.setUserPassword(passwordEncoder.encode(register.getUserPassword()));        
        user.setAccount(accountService.createAccount(user));
        return userRepository.save(user);
	}

}
