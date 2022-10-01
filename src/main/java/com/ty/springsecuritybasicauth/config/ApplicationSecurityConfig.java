package com.ty.springsecuritybasicauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class ApplicationSecurityConfig {

	@Bean
	public InMemoryUserDetailsManager getUserDetails(PasswordEncoder passwordEncoder) {
		UserDetails user = User.withUsername("myuser")
	            .password(passwordEncoder.encode("myuser"))
	            .roles("USER") 
	            .build();
		
		UserDetails merchant = User.withUsername("mymerchant")
	            .password(passwordEncoder.encode("mymerchant"))
	            .roles("MERCHANT")
	            .build();

	        UserDetails admin = User.withUsername("myadmin")
	            .password(passwordEncoder.encode("myadmin"))
	            .roles("USER", "ADMIN")
	            .build();

	        return new InMemoryUserDetailsManager(user, admin, merchant);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}	
