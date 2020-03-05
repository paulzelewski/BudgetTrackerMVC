package com.pzelewski.BudgetTrackerMVC.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
public class Budget {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long budgetId;
	@NotBlank
	@Size(min = 2, max = 32)
	private String budgetName;
	@NotNull
	@Digits(fraction = 2, integer = 17)
	private BigDecimal budgetAmount;
	@Digits(fraction = 2, integer = 17)
	@Transient
	private BigDecimal budgetUsedAmount;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate budgetStartDate;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate budgetEndDate;
	
	//Hibernate relations
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	@OneToMany(mappedBy = "budget")
	private Set<Transaction> transactions;
	
	
	public Long getBudgetId() {
		return budgetId;
	}
	public void setBudgetId(Long budgetId) {
		this.budgetId = budgetId;
	}
	public String getBudgetName() {
		return budgetName;
	}
	public void setBudgetName(String budgetName) {
		this.budgetName = budgetName;
	}
	public BigDecimal getBudgetAmount() {
		return budgetAmount;
	}
	public void setBudgetAmount(BigDecimal budgetAmount) {
		this.budgetAmount = budgetAmount;
	}
	public LocalDate getBudgetStartDate() {
		return budgetStartDate;
	}
	public void setBudgetStartDate(LocalDate budgetStartDate) {
		this.budgetStartDate = budgetStartDate;
	}
	public LocalDate getBudgetEndDate() {
		return budgetEndDate;
	}
	public void setBudgetEndDate(LocalDate budgetEndDate) {
		this.budgetEndDate = budgetEndDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	public BigDecimal getBudgetUsedAmount() {
		return budgetUsedAmount;
	}
	public void setBudgetUsedAmount(BigDecimal budgetUsedAmount) {
		this.budgetUsedAmount = budgetUsedAmount;
	}	

}
