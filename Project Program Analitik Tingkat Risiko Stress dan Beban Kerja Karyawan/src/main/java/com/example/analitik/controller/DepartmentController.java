package com.example.analitik.controller;

import com.example.analitik.model.Department;
import com.example.analitik.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentRepository departments;

    public DepartmentController(DepartmentRepository departments) {
        this.departments = departments;
    }

    @GetMapping
    public List<Department> all() {
        return departments.findAll();
    }

    @PostMapping
    public Department create(@RequestBody Department department) {
        return departments.save(department);
    }
}
