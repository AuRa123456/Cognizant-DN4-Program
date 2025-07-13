package com.cognizant.springlearn.controller;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    private final AuthenticationManager authenticationManager;

    public AuthenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start authenticate");
        LOGGER.debug("Authorization Header: {}", authHeader);

        String user = getUsernameFromHeader(authHeader);
        String password = getPasswordFromHeader(authHeader);

        try {
            Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user, password)
            );

            String token = generateJwt(user);
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            LOGGER.info("End authenticate");
            return response;

        } catch (AuthenticationException ex) {
            LOGGER.error("Authentication failed: {}", ex.getMessage());
            throw ex;
        }
    }

    private String getUsernameFromHeader(String header) {
        return decodeBasicAuth(header)[0];
    }

    private String getPasswordFromHeader(String header) {
        return decodeBasicAuth(header)[1];
    }

    private String[] decodeBasicAuth(String header) {
        String encoded = header.substring(6); // after "Basic "
        byte[] decodedBytes = Base64.getDecoder().decode(encoded);
        String decoded = new String(decodedBytes, StandardCharsets.UTF_8);
        LOGGER.debug("Decoded credentials: {}", decoded);
        return decoded.split(":", 2); // [username, password]
    }

    private String generateJwt(String username) {
        // Use a 256-bit key (32+ characters)
        String secret = "secretkeysecretkeysecretkeysecretkey"; 
        Key key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 20 * 60 * 1000)) // 20 minutes
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}