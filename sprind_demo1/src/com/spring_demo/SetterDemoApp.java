package com.spring_demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		//load the spring configuration file
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		
		CricketCoach theCoach= context.getBean("myCricketCoach",CricketCoach.class);
		
		
		//calll methods on the bean
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		
		//call new methods to  get the literallss values
		System.out.println(theCoach.getEmailAdress());
		System.out.println(theCoach.getTeam());
		
		// close context
		context.close();
		
		
		

	}

}
