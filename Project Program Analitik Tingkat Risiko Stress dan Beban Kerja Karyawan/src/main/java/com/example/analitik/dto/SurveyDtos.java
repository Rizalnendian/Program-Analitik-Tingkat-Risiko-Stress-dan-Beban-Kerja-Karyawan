package com.example.analitik.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class SurveyDtos {
    public record SubmitRequest(
            @NotNull @Min(0) @Max(100) Integer mentalDemand,
            @NotNull @Min(0) @Max(100) Integer physicalDemand,
            @NotNull @Min(0) @Max(100) Integer temporalDemand,
            @NotNull @Min(0) @Max(100) Integer performance,
            @NotNull @Min(0) @Max(100) Integer effort,
            @NotNull @Min(0) @Max(100) Integer frustration,
            @NotNull @Min(0) @Max(5) Integer mentalDemandWeight,
            @NotNull @Min(0) @Max(5) Integer physicalDemandWeight,
            @NotNull @Min(0) @Max(5) Integer temporalDemandWeight,
            @NotNull @Min(0) @Max(5) Integer performanceWeight,
            @NotNull @Min(0) @Max(5) Integer effortWeight,
            @NotNull @Min(0) @Max(5) Integer frustrationWeight,
            String notes
    ) {}

    public record Response(
            Long id,
            Integer stressScore,
            Integer workloadScore,
            Integer nasaTlxScore,
            Integer mentalDemand,
            Integer physicalDemand,
            Integer temporalDemand,
            Integer performance,
            Integer effort,
            Integer frustration,
            Integer mentalDemandWeight,
            Integer physicalDemandWeight,
            Integer temporalDemandWeight,
            Integer performanceWeight,
            Integer effortWeight,
            Integer frustrationWeight,
            String stressLevel,
            String recommendation,
            String notes,
            String submittedAt
    ) {}
}
