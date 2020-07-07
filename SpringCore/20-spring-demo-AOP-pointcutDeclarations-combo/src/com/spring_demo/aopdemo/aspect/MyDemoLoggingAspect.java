package com.spring_demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging

	// let's start with an @Before advice
	
	@Pointcut("execution(* com.spring_demo.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
	@Pointcut("execution(* com.spring_demo.aopdemo.dao.*.get*(..))")
	private void getter() {
		
	}
	@Pointcut("execution(* com.spring_demo.aopdemo.dao.*.set*(..))")
	private void setter() {
		
	}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSeter() {
		
	}
	
	@Before("forDaoPackageNoGetterSeter()")
	public void beforeAddAccountAdvice() {

		System.out.println("\n ====>>>>Executing @Before advice on addAccount()");
	}

	@Before("forDaoPackageNoGetterSeter()")
	public void performApiAnalytics() {
		System.out.println("\n ====>>Perfofrming API Analytics");
	}

}
