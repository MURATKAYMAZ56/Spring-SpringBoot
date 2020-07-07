package com.spring_demo.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.spring_demo.aopdemo.Account;

@Component
public class AccountDAO {
	
	
	private String name;
	private String serviceCode;
	
	
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
