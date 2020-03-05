package com.pzelewski.BudgetTrackerMVC.web;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class AddUpdateBudgetDto {
	
	@NotBlank
	@Size(min = 2, max = 32)
	private String budgetName;
	@NotNull
	@Digits(fraction = 2, integer = 17)
	private BigDecimal budgetAmount;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate budgetStartDate;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate budgetEndDate;
	
	
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
	
	

}
