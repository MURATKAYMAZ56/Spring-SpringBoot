package com.luv2code.springdemo.mvc;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello") //parent  mapping---> showForm and process for are becoming sub mapping
public class HelloWorldController {

	// need CONTROLLER TO SHOW THE INITIal form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// need a controller method to process the HTML form

	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	// new a controller methid to read from data and
	// add data to the model
	@RequestMapping("/processFromVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		
		//read the request parameter from the HTMl form
		String theName= request.getParameter("studentName");
		
		
		//convert the data to all caps
		theName= theName.toUpperCase();
		
		// create the message
		String result= "Yo!"+theName;
		
		//add the message to the model
		
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	
	@RequestMapping("/processFromVersionThree")
	public String processFormVersionThree(@RequestParam("studentName")String theName, Model model) {
		
		
		//read the request parameter from the HTMl form
		
		
		
		//convert the data to all caps
		theName= theName.toUpperCase();
		
		// create the message
		String result= "SpringParam !"+theName;
		
		//add the message to the model
		
		model.addAttribute("message",result);
		
		return "helloworld";
	}
}
