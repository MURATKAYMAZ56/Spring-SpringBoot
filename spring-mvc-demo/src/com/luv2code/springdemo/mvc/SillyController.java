package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {

	public String displayTheFrom() {

		return "Silly";
	}

	// need CONTROLLER TO SHOW THE INITIal form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

}
