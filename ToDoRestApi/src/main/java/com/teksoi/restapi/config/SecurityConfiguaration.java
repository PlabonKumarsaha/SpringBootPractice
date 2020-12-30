//package com.teksoi.restapi.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity 
//public class SecurityConfiguaration extends WebSecurityConfigurerAdapter {
//
//	
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		super.configure(auth);
//		auth.inMemoryAuthentication()
//		.withUser("username")
//		.password("password")
//		.roles("USER")
//		.and()
//		.withUser("adminName")
//		.password("admin")
//		.roles("ADMIN");
//	}
//
//
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		
//		return NoOpPasswordEncoder.getInstance();
//	}
//
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		super.configure(http);
//		http.authorizeRequests()
//		.antMatchers("/admin").hasAnyRole("ADMIN") //most restrictive
//		.antMatchers("/users").hasAnyRole("USER", "ADMIN")
//		.antMatchers("/").permitAll() //least restrictive
//		.and().formLogin();
//	}
//	
//
//}
