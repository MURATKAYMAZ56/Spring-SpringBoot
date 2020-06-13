package com.spring_demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		//load the spring configuration files
		
		ClassPathXmlApplicationContext context= 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		
		Coach theCoach= context.getBean("myCoach",Coach.class);//myCoach is Id, Coach is interface class . fakat neden kullanilmis bilmiyoom :)
		
		// call methods on the beans
		
		System.out.println(theCoach.getDailyWorkout());
		
		//lets call our new method for fortunes
		
		System.out.println(theCoach.getDailyFortune());
		//close the context
		context.close();
		
	}

}
