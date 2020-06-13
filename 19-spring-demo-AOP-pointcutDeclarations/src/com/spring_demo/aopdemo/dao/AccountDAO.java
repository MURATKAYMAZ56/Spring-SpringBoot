package com.spring_demo.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.spring_demo.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account theAccount,boolean vipFlag) {
		
		
		System.out.println(getClass()+":Doing My DB Work: Adding an Account");
	}

}
