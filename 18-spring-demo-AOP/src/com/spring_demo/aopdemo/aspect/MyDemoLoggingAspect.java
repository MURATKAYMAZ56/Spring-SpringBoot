package com.spring_demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging

	// let's start with an @Before advice
	//
	// @Before("execution(public void add*())") we later used down one to see how to
	// use parameter

	// @Before("execution(public void add*(com.spring_demo.aopdemo.Account))")
	//@Before("execution(public void  add*(com.spring_demo.aopdemo.Account,..))")--> matches Account parameter and more 
	@Before("execution(public void  add*(..))")// --> mathces any parameter 
	public void beforeAddAccountAdvice() {

		System.out.println("\n ====>>>>Executing @Before advice on addAccount()");
	}

	/*
	 * NOTE yukaridaki method asagidaki hallde isi ve declare type verilmemisti yani
	 * addAccount method from any class were called. Fakat declare type eklenildi ve
	 * su anda sadece belitilen package teki belirtilen classtaki method
	 * cagirllacak.
	 * 
	 * 
	 * @Before("execution(public void addAccount())") public void
	 * beforeAddAccountAdvice() {
	 * 
	 * System.out.println("\n ====>>>>Executing @Before advice on addAccount()"); }
	 * 
	 * 
	 */

}
