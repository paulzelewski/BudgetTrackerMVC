package com.pzelewski.BudgetTrackerMVC.web;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.sun.istack.NotNull;

public class AddUpdateTransactionDto {
	
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate transactionDate;
	@Size(min=2, max=16)
	private String note;
	@NotNull
	@Digits(fraction = 2, integer = 17)
	private BigDecimal transactionAmount;	
	private boolean isRecurring;
	private long budgetId;
	private int descriptionId;
	private byte statusId;
	
	
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public boolean isRecurring() {
		return isRecurring;
	}
	public void setRecurring(boolean isRecurring) {
		this.isRecurring = isRecurring;
	}
	public long getBudgetId() {
		return budgetId;
	}
	public void setBudgetId(long budgetId) {
		this.budgetId = budgetId;
	}
	public int getDescriptionId() {
		return descriptionId;
	}
	public void setDescriptionId(int descriptionId) {
		this.descriptionId = descriptionId;
	}
	public byte getStatusId() {
		return statusId;
	}
	public void setStatusId(byte statusId) {
		this.statusId = statusId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}	
}
