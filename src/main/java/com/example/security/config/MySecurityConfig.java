package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity security) throws Exception{
		
		security
		.csrf().disable()
		.authorizeRequests()
		//.antMatchers("/signin").permitAll()
		.antMatchers(HttpMethod.GET, "/public/**").hasRole("NORMAL")
		.antMatchers("/users/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		/*.formLogin()
		.loginPage("/signin")
		.loginProcessingUrl("/doLogin")
		.defaultSuccessUrl("/users/fetchAllUsers");*/
	}

	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
		.withUser("kiran")
		.password("password")
		.roles("NORMAL");
		
		auth.inMemoryAuthentication()
		.withUser("mahesh")
		.password("pass")
		.roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}*/
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
		.withUser("kiran")
		.password(this.passwordEncoder().encode("password"))
		.roles("NORMAL");
		
		auth.inMemoryAuthentication()
		.withUser("mahesh")
		.password(this.passwordEncoder().encode("pass"))
		.roles("ADMIN");
	}
	
	/**
	 * ROLE - High Level Overview -> NORMAL :READ
	 * Authority - Permission->READ\
	 * ADMIN- READ, WRITE, UPDATE
	 * 
	 */
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	

}
