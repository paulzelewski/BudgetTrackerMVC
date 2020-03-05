package com.pzelewski.BudgetTrackerMVC.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	@NotNull
	@DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
	private LocalDate transactionDate;
	@Size(min=2, max=16)
	private String note;
	@NotNull
	@Digits(fraction = 2, integer = 17)
	private BigDecimal transactionAmount;
	//TODO implementation of recurring transactions needed
	//private boolean isRecurring;
	
	//hibernate foreign keys and relations
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	@ManyToOne
	private Budget budget;
	@ManyToOne
	private TransactionDescription transactionDescription;
	@ManyToOne
	private TransactionStatus transactionStatus;
	
	
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
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

	/*TODO
	 * public boolean isRecurring() { return isRecurring; } public void
	 * setRecurring(boolean isRecurring) { this.isRecurring = isRecurring; }
	 */
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Budget getBudget() {
		return budget;
	}
	public void setBudget(Budget budget) {
		this.budget = budget;
	}
	public TransactionDescription getTransactionDescription() {
		return transactionDescription;
	}
	public void setTransactionDescription(TransactionDescription transactionDescription) {
		this.transactionDescription = transactionDescription;
	}
	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
		
}
