package com.example.analitik.dto;

import jakarta.validation.constraints.*;

public class ProfileDtos {
    public record ProfileRequest(
            @NotBlank String fullName,
            String employeeNumber,
            String position,
            Long departmentId,
            String phone
    ) {}

    public record ProfileResponse(
            Long userId,
            String email,
            String role,
            String fullName,
            String employeeNumber,
            String position,
            Long departmentId,
            String departmentName,
            String phone
    ) {}
}
