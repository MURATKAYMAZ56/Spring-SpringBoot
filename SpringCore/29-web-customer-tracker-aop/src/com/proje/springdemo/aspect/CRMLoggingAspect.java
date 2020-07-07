package com.proje.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	
	
	
	//setup logger
	
	private Logger myLogger=Logger.getLogger(getClass().getName());
	
	//setuo pointcut declarations
	
	
	
	@Pointcut("execution(* com.proje.springdemo.controller.*.*.(..)")
	private void forControllerPackage() {
		
	}
	
	//do the same for service and dao
	
	@Pointcut("execution(* com.proje.springdemo.service.*.*(..)")
	private void forServicePackage() {
		
	}
	
	
	@Pointcut("execution(* com.proje.springdemo.dao.*.*.(..)")
	private void forDaoPackage() {
		
	}
	
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage() ")
	private void forAppFlow() {
		
		
	}
	//add@Before advice
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		
		//display method  we are calling
		
		
		String theMethod= theJoinPoint.getSignature().toShortString();
		myLogger.info("=====> in @Before: calling method: "+ theMethod);
		
		//display the arguments to the methods
		
		
		//get the argiments
		
		Object[]args=theJoinPoint.getArgs();
		
		//loop through and display args
		for (Object tempArg:args) {
			myLogger.info("===>> argument: "+tempArg);
			
		}
		
		
		
	}
	
	
	
	
	
	//add @AfterReturning
	@AfterReturning(
			pointcut="forAppFLow()",
			returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		//display method we are returning from
		
		
		String theMethod= theJoinPoint.getSignature().toShortString();
		myLogger.info("=====> in @AfterReturning: from method: "+ theMethod);
		
		
		//display data returned
		
		myLogger.info("====>result: "+theResult);
		
	}
	
	
	
	
	
	
	
}
