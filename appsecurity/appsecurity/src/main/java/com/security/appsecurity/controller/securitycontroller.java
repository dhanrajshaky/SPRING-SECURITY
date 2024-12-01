package com.security.appsecurity.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class securitycontroller {



    public class MyController {
        @GetMapping("/update")
        public String update() {
            return "Update Page";
        }

        @GetMapping("/contact")
        public String contact() {
            return "Contact Page";
        }

        @GetMapping("/secure")
        public String secure() {
            return "Secure Page - Requires Authentication";
        }
    }


}
