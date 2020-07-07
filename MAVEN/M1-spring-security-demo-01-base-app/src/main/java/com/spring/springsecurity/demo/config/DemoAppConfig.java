package com.spring.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.spring.springsecurity.demo.config")
public class DemoAppConfig {

	
	
	
	
	
	//define a bean for ViewResolver
	
	
	
	//suffix and prefix normally we did in bean in pom file in the property tag but since we do write
	//our config files we write it here
	
	@Bean
	public ViewResolver viewResolver() {
		
		
		InternalResourceViewResolver viewResolver= new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

				
				
		return viewResolver;
	}
}
