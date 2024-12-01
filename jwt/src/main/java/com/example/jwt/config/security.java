package com.example.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class security {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth ->auth

                        .requestMatchers("**").permitAll()
                        .anyRequest().authenticated()
                );
        return httpSecurity.build();
    }

}
