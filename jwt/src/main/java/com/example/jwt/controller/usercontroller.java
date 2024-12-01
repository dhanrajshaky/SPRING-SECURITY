package com.example.jwt.controller;

import com.example.jwt.helper.jwthelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class usercontroller {

    @Autowired
    private jwthelper jwthelper;


    @PostMapping("/gererate-token")
    public String generateToken(@RequestParam String username,@RequestParam String password)
    {
        if ("admin".equals(username)&&"admin".equals(password)){
            return jwthelper.generateToken(username);
        }else{
            return "Invalid Credentials";
        }
    }
    @GetMapping("/contact")
    public String gererateToken(){
        return "contact us at :2562895692654";
    }

    @GetMapping("/fund-transfer")
    public String secureApi(@RequestHeader(value = "Authorization", required = false) String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);

            // Validate the token
            if (jwthelper.validateToken(token)) {
                return "This is a secured API, token validated!";
            } else {
                return "Invalid token!";
            }
        } else {
            return "Authorization header is missing or malformed!";
        }

    }
}
