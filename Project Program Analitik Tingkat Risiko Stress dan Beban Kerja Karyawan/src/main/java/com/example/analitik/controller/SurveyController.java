package com.example.analitik.controller;

import com.example.analitik.dto.SurveyDtos;
import com.example.analitik.service.SurveyService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {
    private final SurveyService service;

    public SurveyController(SurveyService service) {
        this.service = service;
    }

    @PostMapping
    public SurveyDtos.Response submit(Authentication auth,
                                      @Valid @RequestBody SurveyDtos.SubmitRequest request) {
        return service.submit(auth.getName(), request);
    }

    @GetMapping("/me")
    public List<SurveyDtos.Response> mine(Authentication auth) {
        return service.mine(auth.getName());
    }
}
