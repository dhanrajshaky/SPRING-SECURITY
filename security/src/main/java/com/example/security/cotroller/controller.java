package com.example.security.cotroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
  
    @GetMapping("/update")
    public String update(){
        return "update";
    }

    @GetMapping("/secure")
    public String secure(){
        return "secure ";
    }
}