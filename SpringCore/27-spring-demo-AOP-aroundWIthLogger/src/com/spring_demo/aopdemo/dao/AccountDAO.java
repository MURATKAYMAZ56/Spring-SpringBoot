package com.spring_demo.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;

import com.spring_demo.aopdemo.Account;

@Component
public class AccountDAO {
	
	
	private String name;
	private String serviceCode;
	
	//add a new method: findAccounts()
	
	public List<Account> findAccounts(boolean tripWire){
		
		
		//for academic purpose... simulate an exception
		if(tripWire) {
			throw new RuntimeException("No soup for you");
			
			
		}
		List<Account> myAccounts= new ArrayList<>();
		
		//create sample accounts
		Account temp1= new Account("John","Silver");
		Account temp2= new Account("George","Platinum");
		Account temp3= new Account("Luca","Gold");
		
		//add them to our account list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		return myAccounts;
		
	}
	public void addAccount(Account theAccount,boolean vipFlag) {
		
		
		System.out.println(getClass()+":Doing My DB Work: Adding an Account");
	}


	public String getName() {
		System.out.println(getClass()+":in getName ");
		return name;
	}


	public void setName(String name) {
		System.out.println(getClass()+":in setName ");
		this.name = name;
	}


	public String getServiceCode() {
		System.out.println(getClass()+": in getserviceCode");
		return serviceCode;
	}


	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+": in set serviceCode");
		this.serviceCode = serviceCode;
	}
	
	

}
