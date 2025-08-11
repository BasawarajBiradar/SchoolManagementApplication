package com.example.demo.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // disable CSRF for testing with Postman
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user-management/register", "/login").permitAll() // allow these without authentication
                        .anyRequest().authenticated()
                )
        ; // or formLogin(), depending on what you want
        return http.build();
    }
}

