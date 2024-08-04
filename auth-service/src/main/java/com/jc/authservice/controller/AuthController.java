package com.jc.authservice.controller;

import com.jc.authservice.model.User;
import com.jc.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authservice;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
        if(authservice.ifUserExisted(user)==false){
            authservice.register(user.getUsername(),user.getPassword());
            return ResponseEntity.ok("User registered successfully");
        }else{
            return ResponseEntity.ok("User already existed");
        }

    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) throws Exception{
        try{
            System.out.println("login");
            String token = authservice.login(user.getUsername(),user.getPassword());
            return ResponseEntity.ok(token);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong username or password");

        }


    }
}
