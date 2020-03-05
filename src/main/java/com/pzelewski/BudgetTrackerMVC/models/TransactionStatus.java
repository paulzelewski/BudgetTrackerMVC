package com.pzelewski.BudgetTrackerMVC.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class TransactionStatus {
	
	@Id
	private byte statusId;
	@Size(min = 2, max = 16)
	private String statusName;
	
	@OneToMany(mappedBy = "transactionStatus")
	private List<Transaction> transactions;
		
	
	public byte getStatusId() {
		return statusId;
	}
	public void setStatusId(byte statusId) {
		this.statusId = statusId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}	

}
