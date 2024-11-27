package com.hexaware.roadready.config;
/*
 * Author : Pritesh Rai
 * Description : Configuration Class for spring security
 * Date: 25-11-2024
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hexaware.roadready.filter.JwtAuthFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Autowired
	JwtAuthFilter filter;
	
	private static final String[] SWAGGER_WHITELIST = {
	        "/v3/api-docs/**",        
	        "/swagger-ui/**",          
	        "/swagger-ui.html",       
	        "/webjars/**",             
	        "/swagger-resources/**"    
	    };
	
	@Bean
	UserDetailsService userDetailService() {
		return new UserInfoDetails();
	}
	
	
	@Bean
    public  SecurityFilterChain   getSecurityFilterChain(HttpSecurity http) throws Exception {
    	
    		return http.csrf().disable()
    				.authorizeHttpRequests()
    				.requestMatchers(SWAGGER_WHITELIST).permitAll()
    				.requestMatchers("/api/users/add","/api/users/login")
    				.permitAll()
    				.and()
    				.authorizeHttpRequests().requestMatchers("/api/cars/**","/api/booking/**","/api/users/**","/api/payments/**","/api/reviews/**","/api/roles/**")
    				.authenticated()
    				.and()
    				.sessionManagement()
    				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    				.and()
    				.authenticationProvider(authenticationProvider())
    				.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
    				.build();
    	
    }
	
	
	 @Bean    
	    public PasswordEncoder passwordEncoder() {          
	        return new BCryptPasswordEncoder();
	    }
	
	@Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    	
    	return config.getAuthenticationManager();
    	
    }
}
