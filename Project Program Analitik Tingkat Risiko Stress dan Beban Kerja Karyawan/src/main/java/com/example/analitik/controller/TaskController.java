package com.example.analitik.controller;

import com.example.analitik.dto.TaskDtos;
import com.example.analitik.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasRole('MANAJER')")
    public TaskDtos.Response create(Authentication auth, @Valid @RequestBody TaskDtos.CreateRequest request) {
        return service.create(auth.getName(), request);
    }

    @GetMapping("/me")
    public List<TaskDtos.Response> mine(Authentication auth) {
        return service.mine(auth.getName());
    }

    @GetMapping
    @PreAuthorize("hasRole('MANAJER')")
    public List<TaskDtos.Response> all() {
        return service.all();
    }
}
