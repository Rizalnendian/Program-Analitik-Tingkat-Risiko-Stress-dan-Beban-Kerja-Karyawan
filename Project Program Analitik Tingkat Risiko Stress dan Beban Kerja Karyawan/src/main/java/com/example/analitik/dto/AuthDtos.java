package com.example.analitik.dto;

import jakarta.validation.constraints.*;

public class AuthDtos {

    public record SignupRequest(
            @NotBlank String fullName,

            @NotBlank
            @Email
            String email,

            @NotBlank
            @Size(min = 6)
            String password,

            @NotBlank
            String gender,

            @NotNull
            String role
    ) {}

    public record LoginRequest(
            @NotBlank
            @Email
            String email,

            @NotBlank
            String password
    ) {}

    public record AuthResponse(
            String token,
            String email,
            String fullName,
            String gender,
            String role
    ) {}
}