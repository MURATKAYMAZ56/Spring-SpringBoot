package com.spring_demo.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_demo.aopdemo.dao.AccountDAO;
import com.spring_demo.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {

		// read spring config java class

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the beans from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		//cal methid to find accounts
		List<Account>theAccounts= theAccountDAO.findAccounts();
		
		//display the accounts
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("-------");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		
	

		context.close();

	}

}
