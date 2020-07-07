package com.spring_demo.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_demo.aopdemo.dao.AccountDAO;
import com.spring_demo.aopdemo.dao.MembershipDAO;
import com.spring_demo.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring config java class

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the beans from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\nMain Progran: Around App");
		System.out.println("Calling getFortune");
		String data= theFortuneService.getFortune();
		System.out.println("\nMy fortune is: "+ data);
		System.out.println("finished");
		

		context.close();

	}

}
