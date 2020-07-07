package com.spring.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// add our users for in memory authetication

		auth.inMemoryAuthentication().withUser("Murat").password("test123").roles("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("john").password("test123").roles("MANAGER");
		auth.inMemoryAuthentication().withUser("HUSO").password("test123").roles("ADMIN");

	}

}
