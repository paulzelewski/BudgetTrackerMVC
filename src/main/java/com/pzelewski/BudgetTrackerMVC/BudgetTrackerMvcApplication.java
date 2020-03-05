package com.pzelewski.BudgetTrackerMVC;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BudgetTrackerMvcApplication {
	
	
	@PostConstruct public void init(){
		// Setting Spring Boot SetTimeZone
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	 

	public static void main(String[] args) {
		System.out.println(java.util.TimeZone.getDefault().getID());
		System.out.println(java.util.TimeZone.getDefault());
		SpringApplication.run(BudgetTrackerMvcApplication.class, args);
	}

}
