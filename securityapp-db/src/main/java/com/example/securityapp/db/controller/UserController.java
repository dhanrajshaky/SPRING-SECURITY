package com.example.securityapp.db.controller;


import com.example.securityapp.db.entity.UserEntity;
import com.example.securityapp.db.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepo userRepo;
   @GetMapping("/admin")
    public String adminkaMethod()
    {
        return "main admin hu";

    }

    @GetMapping("/user")
    public String userKaMethod(){
        return "user ya admin hu main";
    }

    @GetMapping("/db")
    public Optional<UserEntity> dbKaMethod()
    {
        return userRepo.findByEmail("shakyadhanraj9@gamil.com");
    }

}
