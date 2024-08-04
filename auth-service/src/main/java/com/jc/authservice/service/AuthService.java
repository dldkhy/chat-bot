package com.jc.authservice.service;

import com.jc.authservice.model.User;
import com.jc.authservice.repository.UserRepository;

import com.jc.authservice.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public void register(String username, String rawPassword) {
        System.out.println("Register method in AuthService called");
        String encodedPassword = passwordEncoder.encode(rawPassword);
        User user = new User();
        user.setPassword(encodedPassword);
        user.setUsername(username);
        userRepository.save(user);
    }
    public boolean ifUserExisted(User user){
        if(userRepository.findByUsername(user.getUsername())!=null){
            return true;
        }else{
            return false;
        }
    }
    public String login(String username, String password)throws Exception {
        System.out.println("Login method in AuthService called");
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            return jwtTokenProvider.generateToken(authentication.getName());
        }catch(Exception e){
            throw new Exception("Authentication failed");
        }
    }
}
