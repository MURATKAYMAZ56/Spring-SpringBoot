package com.spring_demo.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_demo.aopdemo.dao.AccountDAO;
import com.spring_demo.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the beans from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// get membership bean from spring container

		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		// call the business method
		Account myAccount= new Account();
		theAccountDAO.addAccount(myAccount,true);
		
		
		//cal the accountdao getters and setters
		theAccountDAO.setName("murat");
		theAccountDAO.setServiceCode("specialX");
		
		
		String name= theAccountDAO.getName();
		String code= theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addSillyMember();
		// close the context

		context.close();

	}

}
