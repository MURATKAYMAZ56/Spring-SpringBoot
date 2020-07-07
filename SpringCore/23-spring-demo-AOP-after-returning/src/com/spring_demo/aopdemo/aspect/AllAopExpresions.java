package com.spring_demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AllAopExpresions {

	@Pointcut("execution(* com.spring_demo.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
		
	}
	
	@Pointcut("execution(* com.spring_demo.aopdemo.dao.*.get*(..))")
	public void getter() {
		
	}
	@Pointcut("execution(* com.spring_demo.aopdemo.dao.*.set*(..))")
	public void setter() {
		
	}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSeter() {
		
	}
	
	
}
