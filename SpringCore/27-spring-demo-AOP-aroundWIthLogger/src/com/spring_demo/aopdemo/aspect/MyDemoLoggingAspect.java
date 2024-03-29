package com.spring_demo.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.spring_demo.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger myLogger= Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.spring_demo.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		
		//print out method we are advising on
		
		
		String method= theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>> Executing @Around (finally) on methid: "+method	);
		

		
		//get begin timestamp
		
		long begin= System.currentTimeMillis();
		
		
		
		//now let's execute the method
		
		
		Object result = theProceedingJoinPoint.proceed();
		
		//get end stamp
		long end= System.currentTimeMillis();
		
		//compute duration and display it
		
		long duration=  end-begin;
		
		myLogger.info("\n ====>Duration "+duration/1000.0+" seconds");
		
		
		return result;
	}
	
	@After("execution(* com.spring_demo.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		//printout which method we are advising on
				String method= theJoinPoint.getSignature().toShortString();
				myLogger.info("\n====>>> Executing @After (finally) on methid: "+method	);
				
	}
	
	
	
	
	@AfterThrowing(
			
			pointcut="execution(* com.spring_demo.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc"
			)
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		//print out which method we are advising on
		//printout which method we are advising on
				String method= theJoinPoint.getSignature().toShortString();
				myLogger.info("\n====>>> Executing @AfterThrowing on methid: "+method	);
				
		
		//log the exception
				myLogger.info("\n===>>>The exception  is: "+theExc);
		
	}
	
	
	@AfterReturning(
			pointcut="execution(* com.spring_demo.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		//printout which method we are advising on
		String method= theJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>> Executing @AfterReturning on methid: "+method	);
		
		
		//print out the results of the method call
		
		myLogger.info("\n===>>>result is: "+result);
		
		
		
		//let's  post-process the data... let'f modify
		
		
		//convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("\n===>>>result is: "+result);
	}
	
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		//loop through accounts
		for(Account tempAccount:result) {
			
			//get uppercase version of name
			String theUpperName=tempAccount.getName().toUpperCase();
			
			
			//update the name on the account object
			tempAccount.setName(theUpperName);
		}
		
		
		
		
	}









	@Before("com.spring_demo.aopdemo.aspect.AllAopExpresions.forDaoPackageNoGetterSeter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

		myLogger.info("\n ====>>>>Executing @Before advice on addAccount()");

		// display the method signature

		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

		myLogger.info("Method: " + methodSig);

		// display method argument do folowing 2 stepa

		// get args
		Object[] args = theJoinPoint.getArgs();

		// loop through the args

		for (Object tempArg : args) {
			
			myLogger.info(tempArg.toString());
			
			if (tempArg instanceof Account) {
				// downcast and print Account specific stuff

				Account theAccount = (Account) tempArg;
				
				myLogger.info("account name: " + theAccount.getName());
				
				myLogger.info("account level" + theAccount.getLevel());

			}
		}
	}

}
