package com.example.analitik.controller;

import com.example.analitik.dto.ProfileDtos;
import com.example.analitik.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    private final ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    @GetMapping
    public ProfileDtos.ProfileResponse get(Authentication auth) {
        return service.get(auth.getName());
    }

    @PostMapping
    public ProfileDtos.ProfileResponse save(Authentication auth,
                                             @Valid @RequestBody ProfileDtos.ProfileRequest request) {
        return service.saveOrUpdate(auth.getName(), request);
    }
}
