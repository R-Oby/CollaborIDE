package com.r_oby.collaborIDE.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthController {

    private final AuthenticationManager authManager;

    public AuthController(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    public static class LoginRequest {
        public String username;
        public String password;
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        System.out.println("Login hit: username=" + req.username);

        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.username, req.password)
        );
        return ResponseEntity.ok("Authentication successful!");
    }
}
