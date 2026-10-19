package com.example.analitik.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class TaskDtos {
    public record CreateRequest(
            @NotNull Long employeeId,
            @NotBlank String taskName,
            String description,
            @Min(1) @Max(100) Integer workloadPoint,
            @NotNull LocalDate deadline
    ) {}

    public record Response(
            Long id,
            Long employeeId,
            String employeeEmail,
            String taskName,
            String description,
            Integer workloadPoint,
            LocalDate deadline,
            String createdAt
    ) {}
}
