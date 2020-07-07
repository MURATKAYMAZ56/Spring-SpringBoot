package com.spring.springsecurity.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {

		// here home represent home.jsp
		// it goes to view and runs home.jsp
		
		return "home";
	}
}
