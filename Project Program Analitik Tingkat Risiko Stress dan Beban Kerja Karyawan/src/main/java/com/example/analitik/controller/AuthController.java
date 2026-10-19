package com.example.analitik.controller;

import com.example.analitik.dto.AuthDtos;
import com.example.analitik.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody AuthDtos.SignupRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthDtos.LoginRequest request) {
        return ResponseEntity.ok(service.login(request));
    }
}
