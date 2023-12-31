package com.example.linqspring.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenProvider {
    private static final String SECURITY_KEY = "jwtseckey!@";

    public String create(String userId){
        //만료 날짜 현재+1시간
        Date exprTime = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));
        //hs512알고리즘 사용
        return Jwts.builder().signWith(SignatureAlgorithm.HS512,SECURITY_KEY)
                .setSubject(userId).setIssuedAt(new Date()).setExpiration(exprTime)
                .compact();
    }
    public String validate(String token){
        //암호화 알고리즘
        Claims claims = Jwts.parser().setSigningKey(SECURITY_KEY).parseClaimsJws(token).getBody();

        return claims.getSubject();
    }
}
