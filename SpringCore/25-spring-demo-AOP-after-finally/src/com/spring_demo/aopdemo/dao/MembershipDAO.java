package com.spring_demo.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addSillyMember() {
		
		System.out.println(getClass()+":Doing STuff : adding a mambership account");
	}
	

}
