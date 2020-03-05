package com.pzelewski.BudgetTrackerMVC.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class TransactionDescription {
	
	@Id
	private int descriptionId;
	@Size(min = 2, max = 32)
	private String descriptionName;
	
	@OneToMany(mappedBy = "transactionDescription")
	private List<Transaction> transactions;

	
	public int getDescriptionId() {
		return descriptionId;
	}

	public void setDescriptionId(int deescriptionId) {
		this.descriptionId = deescriptionId;
	}
	
	public String getDescriptionName() {
		return descriptionName;
	}

	public void setDescriptionName(String descriptionName) {
		this.descriptionName = descriptionName;
	}

}
