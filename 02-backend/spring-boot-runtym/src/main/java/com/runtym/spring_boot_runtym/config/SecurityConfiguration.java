package com.runtym.spring_boot_runtym.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.security.config.Customizer;


@Configuration
public class SecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable()) // Disable CSRF
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/api/books/secure/**").authenticated()
	        )
	        .oauth2ResourceServer(oauth2 -> oauth2.jwt()) // OAuth2 JWT Configuration
	        .cors(Customizer.withDefaults()) // Enable CORS
	        .setSharedObject(ContentNegotiationStrategy.class,
	            new HeaderContentNegotiationStrategy());

	    Okta.configureResourceServer401ResponseBody(http);

	    return http.build();
	}

}
