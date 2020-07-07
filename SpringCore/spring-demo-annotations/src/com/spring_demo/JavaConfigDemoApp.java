package com.spring_demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

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
