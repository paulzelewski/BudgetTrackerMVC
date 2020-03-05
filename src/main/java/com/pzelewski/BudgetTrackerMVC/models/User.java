package com.pzelewski.BudgetTrackerMVC.models;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;

@Component
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@Size(min=2, max=16)
	private String userName;
	@NotNull
	private String userPassword;
	@Email
	private String userEmail;
	
	//Hibernate relations
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Account account;
	@OneToMany(mappedBy = "user")
	private Set<Transaction> transactions;
	@OneToMany(mappedBy = "user")
	private Set<Budget> budgets;
	
	public User() {}
	
	public User(String userName, String userPassword, String userEmail) {
		
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Set<Budget> getBudgets() {
		return budgets;
	}

	public void setBudgets(Set<Budget> budgets) {
		this.budgets = budgets;
	}
	
}
