package com.spring_demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get bean from container

		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		// call a method on the bean

		System.out.println(theCoach.getDailyWorkOut());
		//call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		// close the context

		context.close();
	}

}
