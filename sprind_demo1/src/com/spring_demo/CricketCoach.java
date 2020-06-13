package com.spring_demo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	//add new fields for email and team
	private String emailAdress;
	private String team;
	
	
	///create no arg instructor
	
	public CricketCoach() {
		
		System.out.println("CrciketCoach:inside no-arg contsr");
	}
	
	
public String getEmailAdress() {
		return emailAdress;
	}



	public void setEmailAdress(String emailAdress) {
		
		System.out.println("CrciketCoach:inside setter method-setEmailAdress");
		this.emailAdress = emailAdress;
	}


	public String getTeam() {
		return team;
	}



	public void setTeam(String team) {
		System.out.println("CrciketCoach:inside setter method-setTeam");
		this.team = team;
	}







	//setter method 
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CrciketCoach:inside  setter method");
		this.fortuneService = fortuneService;
	}


	@Override
	public String getDailyWorkout() {
		
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
