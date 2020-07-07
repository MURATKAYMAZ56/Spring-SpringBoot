package com.spring_demo;

public class BaseballCoach implements Coach {
	
	
	//define a private field for the dependency
	private FortuneService fortuneService;
	
	
	
	//define a constructir for depemndency ijection
	
	public BaseballCoach(FortuneService theFortuneService) {
	
		fortuneService = theFortuneService;
	}


	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practices";
		
	}

	
	@Override
	public String getDailyFortune() {
		// use my fortune to get a fortune
		
		return fortuneService.getFortune();
	}
}
