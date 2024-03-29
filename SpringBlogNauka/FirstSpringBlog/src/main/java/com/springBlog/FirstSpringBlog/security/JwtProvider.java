package com.springBlog.FirstSpringBlog.security;


import com.springBlog.FirstSpringBlog.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import javax.annotation.PostConstruct;
import java.security.Key;

@Service
public class JwtProvider {

    private Key key;

    @PostConstruct
    public void init(){
        key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    }
    public String generateToken(Authentication authentication){
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUserName())
                .signWith(key)
                .compact();
    }
}