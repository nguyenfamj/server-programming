package com.serverprogramming.bookstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login")
				.defaultSuccessUrl("/booklist", true).permitAll().and().logout().permitAll();

		http.headers().frameOptions().sameOrigin();
		return http.build();
	}

	@Bean

	public UserDetailsService userDetailService() {
		List<UserDetails> users = new ArrayList<UserDetails>();
		@SuppressWarnings("deprecation")
		UserDetails user = User.withDefaultPasswordEncoder().username("user1").password("password1").roles("USER")
				.build();

		@SuppressWarnings("deprecation")
		UserDetails userAdmin = User.withDefaultPasswordEncoder().username("admin").password("adminpassword1")
				.roles("ADMIN").build();
		users.add(user);
		users.add(userAdmin);
		
		return new InMemoryUserDetailsManager(users);
	}
}
