package com.mtoliv.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
        .antMatchers("/", "/home").permitAll()
        .and()
        .formLogin()
        .loginPage("/login").permitAll()
        .and()
        .logout().logoutUrl("/logout")
        .logoutSuccessUrl("/hello")
        .permitAll();
		//http.addFilterBefore(customizeFilterSecurityInterceptor, FilterSecurityInterceptor.class)
        http.csrf().disable();
	}
}