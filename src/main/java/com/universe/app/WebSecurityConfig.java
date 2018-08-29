package com.universe.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
			.and()
				.authorizeRequests()
				.antMatchers("/user/**")
				.hasAnyRole("USER", "ADMIN")
				.antMatchers("/admin/**")
				.hasRole("ADMIN")
				.antMatchers("/rest/**")
				.hasAnyRole("USER", "ADMIN")
			.and()
				.authorizeRequests()
				.antMatchers("/h2-console")
				.permitAll()
			.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
				.logout()
				.logoutSuccessUrl("/")
				.permitAll().and()
				.exceptionHandling()
				.accessDeniedPage("/access-denied");
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
	}

}
