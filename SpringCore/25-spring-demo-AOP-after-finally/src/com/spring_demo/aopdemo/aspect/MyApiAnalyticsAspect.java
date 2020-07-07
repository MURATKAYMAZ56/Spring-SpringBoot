package com.spring_demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

	@Before("com.spring_demo.aopdemo.aspect.AllAopExpresions.forDaoPackageNoGetterSeter()")
	public void performApiAnalytics() {
		System.out.println("\n ====>>Perfofrming API Analytics");
	}
	
	
}
