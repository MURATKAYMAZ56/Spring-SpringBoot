package com.spring_demo.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;


@Component
public class TrafficFortuneService {

	// simulate a delay;

	public String getFortune() {

		try {
			TimeUnit.SECONDS.sleep(5);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return "Expect heavy traffic this morning";
	}

	// return a fortune
}
