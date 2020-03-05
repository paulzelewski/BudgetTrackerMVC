package com.pzelewski.BudgetTrackerMVC.web;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.pzelewski.BudgetTrackerMVC.constraints.FieldMatch;

@FieldMatch.List({
	@FieldMatch(first="userPassword", second="userConfirmPassword", message="The password fields must match."),
	@FieldMatch(first="userEmail", second="userConfirmEmail", message="The e-mail fields must match.")
})
public class UserRegistrationDto {
	
	@Pattern(regexp = "\\w\\D+", message="Only english alphabetical, space separated, characters allowed." )
	@NotEmpty
	@Size(min=2, max=16)
	private String userName;
	@NotEmpty
	@Size(min=8, max=32)
	private String userPassword;
	@NotEmpty
	private String userConfirmPassword;
	@Email
	@NotEmpty
	private String userEmail;
	@Email
	@NotEmpty
	private String userConfirmEmail;
	@AssertTrue
	private Boolean terms;
	
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
	public String getUserConfirmPassword() {
		return userConfirmPassword;
	}
	public void setUserConfirmPassword(String userConfirmPassword) {
		this.userConfirmPassword = userConfirmPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserConfirmEmail() {
		return userConfirmEmail;
	}
	public void setUserConfirmEmail(String userConfirmEmail) {
		this.userConfirmEmail = userConfirmEmail;
	}
	public Boolean getTerms() {
		return terms;
	}
	public void setTerms(Boolean terms) {
		this.terms = terms;
	}
	
	
}

