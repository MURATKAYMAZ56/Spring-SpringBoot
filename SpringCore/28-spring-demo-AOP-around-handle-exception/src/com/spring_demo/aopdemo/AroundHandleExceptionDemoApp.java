package com.spring_demo.aopdemo;

import java.util.List;
import java.util.logging.Logger;
 
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_demo.aopdemo.dao.AccountDAO;
import com.spring_demo.aopdemo.dao.MembershipDAO;
import com.spring_demo.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	
	private static Logger myLogger=
							Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {

		// read spring config java class

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the beans from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\nMain Progran: Around App");
		myLogger.info("Calling getFortune");
		
		
		boolean tripWire=true;
		String data= theFortuneService.getFortune(tripWire);
		myLogger.info("\nMy fortune is: "+ data);
		myLogger.info("finished");
		

		context.close();

	}

}
