package com.spring_demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
/*
// @Scope("prototype")
// above we used to see default scope is singleton and two different instance refer to the same object
// after making scope prototype then both instance refer to different object. 
 * 
 * 
 */
public class TennisCoach implements Coach {

	private FortuneService fortuneService;
	
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
	this.fortuneService=fortuneService;
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	//define my init method
	
			@PostConstruct
			public void doMyStartupStuff() {
				System.out.println(">> TennisCoach: inside of doMyStartupStaff");

			}
	
	
	
	//define my destroy method
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanupStuff");


	}
	
	

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	

}
