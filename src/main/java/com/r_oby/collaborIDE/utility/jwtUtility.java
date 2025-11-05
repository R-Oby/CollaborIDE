package com.r_oby.collaborIDE.utility;

import org.bouncycastle.jcajce.BCFKSLoadStoreParameter.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

public class jwtUtility {
    private final String SECRET_KEY = "bobby";

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
      .setSubject(userDetails.getUsername())
      .setIssuedAt(new Date())
      .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
      .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
      .compact();
  }
    }   
}
