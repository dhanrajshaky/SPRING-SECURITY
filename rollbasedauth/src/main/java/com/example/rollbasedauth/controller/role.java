package com.example.rollbasedauth.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class role {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminkaMethod(){
        return "main hu admin";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String userkaMethod(){
        return "main hu admin ya user";
    }


}
