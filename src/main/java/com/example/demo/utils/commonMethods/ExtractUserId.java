package com.example.demo.utils.commonMethods;

import com.example.demo.security.JwtKeyProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class ExtractUserId {
    private final Key key;

    public ExtractUserId(JwtKeyProvider keyProvider) {
        this.key = keyProvider.getKey();
    }

    public String extractUserId(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.get("userId", String.class);
    }
}