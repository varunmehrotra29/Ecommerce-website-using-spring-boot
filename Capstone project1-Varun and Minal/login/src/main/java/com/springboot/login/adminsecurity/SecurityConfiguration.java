package com.springboot.login.adminsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		auth.inMemoryAuthentication()
		.withUser("varun")
		.password("Varun@2998")
		.roles("admin");
		
		
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
	 
		return NoOpPasswordEncoder.getInstance();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable();
		http.headers().frameOptions().sameOrigin();
		http.authorizeRequests()
		    .antMatchers("/admin").hasRole("admin")
		    .antMatchers("/").permitAll()
		    .and().formLogin();
		
	}
	
	

}
