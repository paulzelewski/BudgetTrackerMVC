package com.pzelewski.BudgetTrackerMVC.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
public class Account {
	
	@Id	
	private Integer userId;
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate accountCreationDate;
	@NotNull @ColumnDefault(value = "0.00")
	@Digits(fraction = 2, integer = 17)
	private BigDecimal accountBalance;
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "user_id")
	private User user;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public LocalDate getAccountCreationDate() {
		return accountCreationDate;
	}
	public void setAccountCreationDate(LocalDate accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
