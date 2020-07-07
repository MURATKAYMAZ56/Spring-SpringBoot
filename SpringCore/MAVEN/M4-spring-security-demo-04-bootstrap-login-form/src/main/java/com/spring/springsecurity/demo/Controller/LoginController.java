package com.spring.springsecurity.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	
	@GetMapping("/showLoginPage")
	public String  showLoginPage() {
		
		
		//return "plain-login";  //we used bootstrap no need this anymore use fancy jsp file
		return "fancy-login";
	}
	
	
	
	

}
