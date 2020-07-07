package com.spring_demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		//load the spring configuration file
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("beanscope-applicationContext2.xml");
		
		//retrieve bean from spring container
Coach theCoach= context.getBean("myCoach",Coach.class);
Coach alphaCoach= context.getBean("myCoach",Coach.class);


//check if they are the same
// here we saw that bean scope defautlt is singletin and pointing to the same memory 
//with next we are going to add  scope(in xml file ) and see it location 


boolean result=(theCoach==alphaCoach);
System.out.println( "\n Pointing to the same object"+result);
System.out.println("\n Memory location for " +theCoach);

System.out.println("\n Memory location for " +alphaCoach);

context.close();


	}
}
