package com.example.analitik.controller;

import com.example.analitik.dto.AnalyticsDtos;
import com.example.analitik.service.AnalyticsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {
    private final AnalyticsService service;

    public AnalyticsController(AnalyticsService service) {
        this.service = service;
    }

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('MANAJER')")
    public AnalyticsDtos.Dashboard dashboard(@RequestParam(required = false) Long departmentId) {
        return service.dashboard(departmentId);
    }
}
