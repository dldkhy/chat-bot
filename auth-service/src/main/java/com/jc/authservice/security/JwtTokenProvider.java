package com.jc.authservice.security;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;

import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);
        return JWT.create()
                .withSubject(username)
                .withIssuedAt(now)
                .withExpiresAt(expiryDate)
                .sign(Algorithm.HMAC512(secret));
    }

    public boolean validateToken(String token){
        try{
            JWTVerifier verifier =JWT.require(Algorithm.HMAC512(secret)).build();
            verifier.verify(token);
            return true;
        }catch(JWTVerificationException exception){
            return false;
        }
    }

    public String getUsername(String token){
        return JWT.decode(token).getSubject();
    }

}
