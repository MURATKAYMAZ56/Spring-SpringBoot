package com.spring_demo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneSevice;
	
	@Value("${foo.email}")
	private String email;
	
	
	@Value("${foo.team}")
	private String team;

	public SwimCoach(FortuneService fortuneSevice) {
		super();
		this.fortuneSevice = fortuneSevice;
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String getDailyWorkOut() {

		return "Swim 1000 m as a warm up";
	}

	@Override
	public String getDailyFortune() {

		return fortuneSevice.getFortune();
	}

}
