package com.example.jwt.helper;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;


import java.security.Key;
import java.util.Date;

@Component
public class jwthelper {

    private static final String SECRET_KEY_STRING = "dhanraj19473hksjdf73462489hf625849723487248254";
    private final Key SECRET_KEY= Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes());


    public String generateToken(String username){
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*30))
                .signWith(SECRET_KEY)
                .compact();

        System.out.println("Generatee Token " + token);
        return token;

    }
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
            return true; // Token is valid
        } catch (ExpiredJwtException e) {
            System.out.println("Token expired: " + e.getMessage());
            return false; // Token expired
        } catch (SignatureException e) {
            System.out.println("Invalid JWT signature: " + e.getMessage());
            return false; // Signature mismatch
        } catch (MalformedJwtException e) {
            System.out.println("Invalid JWT token: " + e.getMessage());
            return false; // Token is malformed
        } catch (UnsupportedJwtException e) {
            System.out.println("JWT token is unsupported: " + e.getMessage());
            return false; // Token unsupported
        } catch (JwtException e) {
            System.out.println("JWT exception: " + e.getMessage());
            return false; // General JWT exception
        }
    }
}
