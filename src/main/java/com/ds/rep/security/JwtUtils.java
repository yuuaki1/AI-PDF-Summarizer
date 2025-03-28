// package com.ds.rep.security;

// import java.security.Key;
// import java.util.Date;

// import org.springframework.stereotype.Component;

// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.io.Decoders;
// import io.jsonwebtoken.security.Keys;
//  // for token generation
// @Component
// public class JwtUtils {
    
//     private final String SECRET_KEY = "your-secret-key";

//     private Key getSignInKey() {
//         byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
//         return Keys.hmacShaKeyFor(keyBytes);
//     }

//     public String generateToken(String username) {
//         return Jwts.builder()
//                 .subject(username)
//                 .issuedAt(new Date())
//                 .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
//                 .signWith(getSignInKey())
//                 .compact();
//     }

//     public String extractUsername(String token) {
//         return Jwts.parser()
//                 .verifyWith(getSignInKey())
//                 .build()
//                 .parser

//     }
// }
