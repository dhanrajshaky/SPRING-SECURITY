package com.example.security.config;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/update").permitAll() // Allow access to these endpoints
                        .anyRequest().authenticated() // All other endpoints require authentication
                )
                .formLogin(Customizer.withDefaults()) // Enable default login form
                .httpBasic(Customizer.withDefaults()); // Enable HTTP Basic Auth

        return httpSecurity.build();
    }
}
